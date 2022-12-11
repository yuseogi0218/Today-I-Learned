package springbook.learningtest.template;

public interface LineCallback<T> {
    T doSomethingWithLineCallback(String line, T value);
}
