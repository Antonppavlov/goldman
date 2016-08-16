package ru.coldman.game.objects.sound;


import ru.coldman.game.abstracts.AbstractMovingObject;
import ru.coldman.game.enums.ActionResult;
import ru.coldman.game.objects.listeners.MoveResultListener;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WavPlayer implements MoveResultListener {

    public static final String WAV_DIE = "die.wav";

    @Override
    public void notifyActionResult(ActionResult actionResult, final AbstractMovingObject abstractMovingObject) {
        if (!(abstractMovingObject instanceof SoundObject)) {

            return;

        }


        SoundObject soundObject = (SoundObject) abstractMovingObject;

        playSound(soundObject.getSoundName(actionResult), false, true);

    }

    public void playSound(String name, final boolean loop) {
        playSound(name, loop, false);
    }

    public void playSound(String name, final boolean loop, final boolean stopPrev) {

        try {

            if (name == null) {
                return;
            }
            System.out.println("!");
            URL sound = this.getClass().getResource("/resources/sound/"+name);

            final AudioInputStream ais = AudioSystem.getAudioInputStream(sound);

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {

                        Clip clip = AudioSystem.getClip();

                        if (stopPrev && clip != null) {
                            clip.stop();
                            clip.close();
                        }

                        clip.open(ais);

                        if (loop) {
                            clip.loop(Clip.LOOP_CONTINUOUSLY);
                        } else {
                            clip.start();
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (LineUnavailableException ex) {
                        Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        if (ais != null) {
                            try {
                                ais.close();
                            } catch (IOException ex) {
                                Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

                }
            });


        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
