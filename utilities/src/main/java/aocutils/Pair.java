package aocutils;

public class Pair<I, J> {
    private I _first;
    private J _second;
    public static <I,J> Pair of(I first, J second) {
        return new Pair(first, second);
    }

    private Pair(I first, J second) {
        _first = first;
        _second = second;
    }

    public I first() {
        return _first;
    }

    public J second() {
        return _second;
    }
}
