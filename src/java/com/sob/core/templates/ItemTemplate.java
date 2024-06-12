package com.sob.core.templates;

import java.net.*;

public class ItemTemplate extends Template {

    /** The place where the texture is */
    protected URL texture;

    /**
     * 
     * Returns the texture of this.
     * 
     * @return the texture of this
     */
    public URL getTexture() {
        return texture;
    }

    /**
     * 
     * Sets this texture into a new one.
     * 
     * @param o the new texture
     * @return returns this
     */
    public ItemTemplate setTexture(URL o) {
        texture = o;
        return this;
    }

}
