package com.mylearn.jaeger.lesson2;

import com.google.common.collect.ImmutableMap;
import com.mylearn.jaeger.utils.Tracing;
import io.jaegertracing.internal.JaegerTracer;
import io.opentracing.Span;
import io.opentracing.Tracer;

public class HelloManual {

    private Tracer tracer;

    private HelloManual(Tracer tracer) {
        this.tracer = tracer;
    }

    private String formatString(Span rootSpan, String helloTo){
        // 创建一个新的span，并作为rootSpan的孩子
        Span span =tracer.buildSpan("formating").asChildOf(rootSpan).start();

        try{
            String helloStr = String.format("Hello,%s!",helloTo);
            span.log(ImmutableMap.of("event","string-format","value",helloStr));
            return helloStr;
        }finally {
            span.finish();
        }
    }

    private void printHello(Span rootSpan,String helloStr){
        // 创建一个新的span，并作为rootSpan的孩子
        Span span = tracer.buildSpan("printHello").asChildOf(rootSpan).start();
        try {
            System.out.println(helloStr);
            span.log(ImmutableMap.of("event","println"));
        }finally {
            span.finish();
        }
    }


    private void sayHello(String helloTo){
        // 创建一个span
        Span span =tracer.buildSpan("say-hello").start();
        span.setTag("hello-to",helloTo);

        // 调用formatString方法，并把span传入
        String helloStr = formatString(span,helloTo);
        // 调用printHello方法，并把span传入
        printHello(span,helloStr);

        // 调用finish方法
        span.finish();
    }

    public static void main(String[] args) {
        // 创建一个tracer, tracer的service命名为hello-world
        try (JaegerTracer tracer = Tracing.init("hello-world")){
            new HelloManual(tracer).sayHello("Bob");
        }
    }
}
