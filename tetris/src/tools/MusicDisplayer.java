package tools;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
public class MusicDisplayer {
    static Clip clip; 
    
    
    public static void displayMusic(String musicFile, float volume)
    { 
		String filePath = System.getProperty("user.dir") + "/src/musicPackage/" + musicFile;
		try {
			if(clip != null) {
				clip.stop();
			}
            // create AudioInputStream object 
    		AudioInputStream audioInputStream =  AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile()); 
              
            // create clip reference 
            clip = AudioSystem.getClip(); 
              
            // open audioInputStream to the clip 
            clip.open(audioInputStream); 
		}
        catch(Exception e) {
        	System.err.println(e);
        }
		
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
        gainControl.setValue(20f * (float) Math.log10(volume));
        
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
            clip.start();
    } 
    public static void stopMusic() {
		if(clip != null) {
			clip.stop();
		}
    }
    
    public static void setVolume( float volume){
		if(clip != null) {
	        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);        
	        gainControl.setValue(50f * (float) Math.log10(volume));
		}
    }
}
