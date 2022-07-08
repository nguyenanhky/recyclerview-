package com.example.viewtypedemo;

public class Actor {

    public static final int TYPE_GRID = 1;
    public static final int TYPE_LISt = 2;
    public static final int TYPE_STAGGERED= 3;

    private int resourceImage;
    private int typeDisplay;

    public Actor(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public int getTypeDisplay() {
        return typeDisplay;
    }

    public void setTypeDisplay(int typeDisplay) {
        this.typeDisplay = typeDisplay;
    }

    @Override
    public String toString() {
        return "ActorAdapter{" +
                "resourceImage=" + resourceImage +
                ", typeDisplay=" + typeDisplay +
                '}';
    }
}
