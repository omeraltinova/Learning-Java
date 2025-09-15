package Section13.Nested.Challange;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;  // ArrayList yerine artık SongList kullanıyoruz!

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();  // Inner class'ı başlatıyoruz
    }

    public boolean addSong(String title, double duration) {
        return this.songs.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList) {
        Song checkedSong = songs.findSong(title);
        if (checkedSong != null) {
            playList.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album");
        return false;
    }

    // Inner Class burada başlıyor
    public static class SongList {  // Dikkat: public static yapıyoruz
        private ArrayList<Song> songs;

        private SongList() {
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song) {
            // Şarkı zaten listede var mı kontrol et
            if (findSong(song.getTitle()) != null) {
                return false;  // Şarkı zaten var
            }
            this.songs.add(song);
            return true;  // Başarıyla eklendi
        }

        private Song findSong(String title) {
            // Başlığa göre şarkı ara
            for (Song checkedSong : this.songs) {
                if (checkedSong.getTitle().equals(title)) {
                    return checkedSong;
                }
            }
            return null;  // Bulunamadı
        }

        private Song findSong(int trackNumber) {
            // Track numarasına göre ara (0'dan başlar)
            int index = trackNumber - 1;
            if (index >= 0 && index < songs.size()) {
                return songs.get(index);
            }
            return null;  // Geçersiz track numarası
        }
    }
}
