package com.bignerdranch.android.beatbox;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SoundViewModelTest {
    private BeatBox beatBox;
    private Sound sound;
    private SoundViewModel subject;

    @Before
    public void setUp() throws Exception {
        this.beatBox = mock(BeatBox.class);
        sound = new Sound("assetPath");
        subject = new SoundViewModel(beatBox);
        subject.setSound(sound);
    }

    @Test
    public void exposesSoundNameAsTitle() {
        assertThat(subject.getTitle(), is(sound.getName()));
    }

    @Test
    public void callBeatBoxPlayOnButtonClicked() {
        subject.onButtonClicked();

        verify(beatBox).play(sound);
    }
}