package ru.iteco.fmhandroid.ui;
import androidx.test.espresso.idling.CountingIdlingResource;

class EspressoIdlingResources {
    private static final String RESOURCE = "GLOBAL"; //Tag
    public static CountingIdlingResource idlingResource = new CountingIdlingResource(RESOURCE);
    public static void increment() {
        idlingResource.increment();
    }
    public static void decrement() {
        if(!idlingResource.isIdleNow()) {
            idlingResource.decrement();
        }
    }
}