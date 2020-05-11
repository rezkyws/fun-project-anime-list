package com.example.listanime;

/**
 *{@link Anime} represents an anime that the user wants to see.
 *It contains a default title, a description, and an cover for that anime.
 */
public class Anime {

    /** Default title of anime. */
    private String title;

    /** Default description of anime. */
    private String description;

    /** Constant value that represents no cover was provided for this anime. */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Image resource for anime. */
    private int imageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Create a new anime object.
     *
     * @param title is the title of the anime that will be use as header of list.
     * @param description is the synopsis of the anime.
     */
    public Anime(String title, String description) {
        this.title = title;
        this.description = description;
    }

    /**
     * Create a new anime object.
     *
     * @param title is the title of the anime that will be use as header of list.
     * @param description is the synopsis of the anime.
     * @param imageResourceId is the cover id of the anime.
     */
    public Anime(String title, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    /**
     *
     * @return title of the anime.
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return description of the anime.
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return whether or not there is a cover for this anime.
     */
    public boolean hasImage() {
        return imageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     *
     * @return cover id of the anime.
     */
    public int getImageResourceId() {
        return imageResourceId;
    }
}
