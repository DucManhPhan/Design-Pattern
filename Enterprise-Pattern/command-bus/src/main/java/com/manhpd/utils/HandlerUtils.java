package com.manhpd.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class HandlerUtils {

    private HandlerUtils() {}

    public static boolean canHandle(Class<?> handlerClazz, Class<?> commandClazz) {
        Type[] genericInterface = handlerClazz.getGenericInterfaces();
        ParameterizedType handlerInterfaceType = null;

        for (Type type : genericInterface) {
            if (type instanceof ParameterizedType) {
                handlerInterfaceType = (ParameterizedType) type;
                break;
            }
        }

        Class<?> acceptableParameterClass = (Class<?>) handlerInterfaceType.getActualTypeArguments()[0];
        return acceptableParameterClass.equals(commandClazz);
    }

}
