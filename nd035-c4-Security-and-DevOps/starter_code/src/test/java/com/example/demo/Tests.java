package com.example.demo;
import java.lang.reflect.Field;
public class Tests {
            public static void injectObject(Object target, String fieldName, Object toInject) {
                try {
                    Field field = getField(target.getClass(), fieldName);

                    boolean wasAccessible = setFieldAccessible(field);
                    field.set(target, toInject);
                    resetFieldAccessibility(field, wasAccessible);

                } catch (Exception e) {
                    handleException(e);
                }
            }

            private static Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
                return clazz.getDeclaredField(fieldName);
            }

            private static boolean setFieldAccessible(Field field) {
                boolean wasAccessible = field.isAccessible();
                if (!wasAccessible) {
                    field.setAccessible(true);
                }
                return wasAccessible;
            }

            private static void resetFieldAccessibility(Field field, boolean wasAccessible) {
                if (!wasAccessible) {
                    field.setAccessible(false);
                }
            }

            private static void handleException(Exception e) {
                throw new RuntimeException(e);
            }
        }


