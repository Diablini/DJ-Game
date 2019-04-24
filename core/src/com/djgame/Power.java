package com.djgame;

public abstract class Power {

    public int priority, duration;
    public abstract void Play();
    public abstract void Expire();
}
