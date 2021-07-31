package com.mylearn.jaeger.lesson1;

import com.google.common.collect.ImmutableMap;
import com.mylearn.jaeger.utils.Tracing;
import io.jaegertracing.internal.JaegerTracer;
import io.opentracing.Span;
import io.opentracing.Tracer;

public class Hello {

    private final Tracer tracer;

    private Hello(Tracer tracer) {
        this.tracer = tracer;
    }

    private void sayHello(String helloTo) {
        // 在方法的入口处初始化一个span,并打上标签
        Span span = tracer.buildSpan("say-hello").start();
        span.setTag("hello-to", helloTo);

        // 每执行一个小动作,就记上日志
        String helloStr = String.format("Hello, %s!", helloTo);
        span.log(ImmutableMap.of("event", "string-format", "value", helloStr));

        // 记录日志
        System.out.println(helloStr);
        span.log(ImmutableMap.of("event", "println"));

        // 执行完成后,调用finish方法
        span.finish();
    }

    public static void main(String[] args) {

        String helloTo = "BOB";
        // 初始化一个tracer并执行动作
        try (JaegerTracer tracer = Tracing.init("hello-world")) {
            new Hello(tracer).sayHello(helloTo);
        }
    }
}
