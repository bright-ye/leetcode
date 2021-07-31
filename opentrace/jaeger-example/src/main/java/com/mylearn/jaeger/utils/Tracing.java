package com.mylearn.jaeger.utils;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.SenderConfiguration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.ConstSampler;

public final class Tracing {

    private Tracing() {
    }

    // http://118.190.37.201:14268/api/traces
    // http://192.168.192.100:14268/api/traces
    private static final String endPoint = "http://192.168.192.100:14268/api/traces";

    public static JaegerTracer init(String service) {

        // jaeger ui: http://192.168.192.100:16686/search
        // jaeger controller: http://192.168.192.100:14268/api/traces
        SamplerConfiguration samplerConfiguration = SamplerConfiguration.fromEnv().withType(ConstSampler.TYPE).withParam(1);

        SenderConfiguration senderConfiguration = SenderConfiguration.fromEnv().withEndpoint(endPoint);
        ReporterConfiguration reporterConfiguration = ReporterConfiguration.fromEnv().withSender(senderConfiguration).withLogSpans(true);

        Configuration configuration = new Configuration(service).withSampler(samplerConfiguration).withReporter(reporterConfiguration);

        return configuration.getTracer();
    }

}
