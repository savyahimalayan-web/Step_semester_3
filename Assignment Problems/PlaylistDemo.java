import java.util.Arrays;
public class PlaylistDemo {
    static class Playlist {
        // Private song storage
        private String[] songs;
        // Number of songs added
        private int count;
        // Constructor
        public Playlist(int size) {
            songs = new String[size];
            count = 0;
        }
        // Add song
        public void addSong(String song) {
            if(count < songs.length) {
                songs[count] = song;
                count++;
            }
        }
        // Return copy instead of original array
        public String[] getSongs() {
            return Arrays.copyOf(songs, count);
        }
        // Return number of songs
        public int getSongCount() {
            return count;
        }
    }
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        // Changing copy does not affect original
        copy[0] = "Hacked";
        System.out.println(Arrays.toString(p.getSongs()));
        System.out.println("Count: " + p.getSongCount());
    }
}
