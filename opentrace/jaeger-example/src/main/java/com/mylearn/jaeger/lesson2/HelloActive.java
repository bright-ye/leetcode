package com.mylearn.jaeger.lesson2;

import com.google.common.collect.ImmutableMap;
import com.mylearn.jaeger.utils.Tracing;
import io.jaegertracing.internal.JaegerTracer;
import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;

public class HelloActive {
    private Tracer tracer;

    private HelloActive(Tracer tracer) {
        this.tracer = tracer;
    }

    private String formatString(String helloTo){
        // 创建一个新的span，并作为rootSpan的孩子
        Span span = tracer.buildSpan("formating").start();
        try(Scope scope = tracer.scopeManager().activate(span)){
            String helloStr = String.format("Hello,%s!",helloTo);
            span.log(ImmutableMap.of("event","string-format","value",helloStr));
            return helloStr;
        }finally {
            span.finish();
        }
    }

    private void printHello(String helloStr){
        // 创建一个新的span，并作为rootSpan的孩子
        Span span = tracer.buildSpan("printHello").start();
        try (Scope scope = tracer.scopeManager().activate(span)){
            System.out.println(helloStr);
            span.log(ImmutableMap.of("event","println"));
        }finally {
            span.finish();
        }
    }


    private void sayHello(String helloTo){
        // 创建一个span
        Span span =tracer.buildSpan("say-hello").start();
        try (Scope scope = tracer.scopeManager().activate(span)){
            span.setTag("hello-to",helloTo);

            // 调用formatString方法，并把span传入
            String helloStr = formatString(helloTo);
            // 调用printHello方法，并把span传入
            printHello(helloStr);
        }finally {
            // 调用finish方法
            span.finish();
        }
    }

    public static void main(String[] args) {
        // 创建一个tracer, tracer的service命名为hello-world
        try (JaegerTracer tracer = Tracing.init("hello-active")){
            new HelloActive(tracer).sayHello("Bob");
        }
    }

}
