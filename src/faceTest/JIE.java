package faceTest;

@FunctionalInterface
public interface JIE {
    void call();

    default void call2(){
        System.out.println("111111");
    }
}
