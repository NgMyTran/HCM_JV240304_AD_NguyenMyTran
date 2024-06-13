package ra.service;

import ra.model.Singer;
import ra.model.Song;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class SongService {
    private Song[] songs;
    private static final String[] existingSongIds = new String[100];
    private static final int existingSongCount = 0;
    private String author;

    public SongService(Song[] songs) {
        this.songs = songs;
    }

    public SongService() {
        this.songs = new Song[0];
    }

    public void addSong() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng bài hát cần thêm: ");
        int numberOfSongs = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Song[] newSongs = new Song[numberOfSongs];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date makingDate = null;

        for (int i = 0; i < numberOfSongs; i++) {
            System.out.println("Nhập thông tin bài hát thứ " + (i + 1) + ":");
            scanner = new Scanner(System.in);
            boolean validCheck;
            String songId;

            do {
                System.out.println("Song ID (lớn hơn 4 ký tự, bắt đầu bằng S, không trùng lặp): ");
                songId = scanner.nextLine();
            } while (!validateSongId(songId));

            System.out.print("Nhập tên bài hát: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Tên bài hát không được để trống.");
                return;
            }

            System.out.print("Mô tả: ");
            String descriptions = scanner.nextLine();

            String singerName;
            do {
                System.out.print("Ca sĩ trình bày: ");
                singerName = scanner.nextLine();
                validCheck = !singerName.isEmpty();
                if (!validCheck) {
                    System.out.println("Người sáng tác không được để trống.");
                }
            } while (!validCheck);

            Singer singer = new Singer(singerName);
            do {
                System.out.print("Người sáng tác: ");
                String author = scanner.nextLine();
                validCheck = !author.isEmpty();
                if (!validCheck) {
                    System.out.println("Người sáng tác không được để trống.");
                }
            } while (!validCheck);


            System.out.print("Ngày tạo (yyyy-MM-dd): ");
            String input = scanner.nextLine();
            makingDate = dateFormat.parse(input);

            System.out.print("Trạng thái: Active(input true) / Not Active(input false): ");
            boolean status = scanner.nextBoolean();
            scanner.nextLine();

            Song song = new Song(name, descriptions, singer, author, makingDate, status);
            newSongs[i] = song;

            System.out.println("Đã thêm bài hát: " + name);
        }

        Song[] allSongs = new Song[songs.length + numberOfSongs];
        int index = 0;
        for (Song existingSong : songs) {
            allSongs[index++] = existingSong;
        }
        for (Song newSong : newSongs) {
            allSongs[index++] = newSong;
        }
        songs = allSongs;
    }

    private boolean validateSongId(String songId) {
        if (songId.length() <= 4 || songId.charAt(0) != 'S') {
            System.out.println("Mã bài hát phải lớn hơn 4 ký tự và bắt đầu bằng 'S'.");
            return false;
        }
        return true;
    }


    public void updateSong(String id) {
        Scanner scanner = new Scanner(System.in);
        SingerService singerService = new SingerService();

        for (Song song : songs) {
            if (song.getSongId().equals(id)) {
                System.out.println("Nhập thông tin mới cho bài hát:");

                System.out.print("Tên bài hát: ");
                song.setSongName(scanner.nextLine());

                System.out.print("Mô tả: ");
                song.setDescriptions(scanner.nextLine());

                System.out.print("Mã ca sĩ (ID): ");
                String singerId = scanner.nextLine();

                Singer[] allSingers = singerService.getAllSingers();
                Singer singer = null;

                for (Singer s : allSingers) {
                    if (String.valueOf(s.getSingerId()).equals(singerId)) {
                        singer = s;
                        break;
                    }
                }

                if (singer == null) {
                    System.out.println("Không tìm thấy ca sĩ với mã ID " + singerId);
                    return;
                }

                song.setSinger(singer);
                System.out.println("Thông tin bài hát đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy bài hát với mã ID: " + id);
    }

    public Song[] getLatestSongs(int count) {
        if (count <= 0 || count > songs.length) {
            System.out.println("Không có đủ bài hát để trả về.");
            return new Song[0];
        }
        Arrays.sort(songs, Comparator.comparing(Song::getCreatedDate).reversed());
        return Arrays.copyOfRange(songs, 0, count);
    }

    public Song[] getAllSongs() {
        return songs;
    }

    public void displayAllSongs() {
        for (Song song : songs) {
            System.out.println(song);
        }
    }
public void deleteSong(int id) {
    boolean found = false;
    int index = 0;
    String trimmedId = String.valueOf(id).trim();
    for (int i = 0; i < songs.length; i++) {
        String trimmedSongId = songs[i].getSongId().trim();
        if (trimmedSongId.equals(trimmedId)) {
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Không tìm thấy bài hát với mã ID: " + id);
        return;
    }
    Song[] newSongs = new Song[songs.length - 1];
    for (Song song : songs) {
        String trimmedSongId = song.getSongId().trim();
        if (!trimmedSongId.equals(trimmedId)) {
            newSongs[index++] = song;
        }
    }
    songs = newSongs;
    System.out.println("Bài hát với mã ID " + id + " đã được xoá.");
}

}
