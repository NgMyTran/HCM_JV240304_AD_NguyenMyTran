package ra.model;
import ra.model.Singer;
import java.util.Date;
import java.util.Scanner;
public class Song {
    private static int autoSongId = 1;
    private String songId, songName, songWriter, descriptions;
    private Singer singer;
    private Date createdDate;
    private boolean songStatus;
    private static final String[] existingSongIds = new String[100];
    private static final int existingSongCount = 0;

    public Song(String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = String.valueOf(autoSongId++);
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = singer;
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public Song() {
    }

    // Getters and setters
    public String getSongId() {
        return songId;
    }
    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }
    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Singer getSinger() {
        return singer;
    }
    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getSongWriter() {
        return songWriter;
    }
    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }
    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId='" + songId + '\'' +
                ", songName='" + songName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", singer=" + singer +
                ", songWriter='" + songWriter + '\'' +
                ", createdDate=" + createdDate +
                ", songStatus=" + songStatus +
                '}';
    }

    // Method to input data
//Scanner scanner = new Scanner(System.in);
//    public void inputDataSong() {
//        while (true) {
//            if (this.songId.length() >= 4 && this.songId.charAt(0) == 'S') {
//                boolean trungLap = false;
//                for (int i = 0; i < existingSongCount; i++) {
//                    if (existingSongIds[i].equals(this.songId)) {
//                        trungLap = true;
//                        break;
//                    }
//                }
//                if (trungLap) {
//                    System.out.println("Mã số bài hát trùng lặp. Vui lòng nhập mã số khác.");
//                    System.out.print("Mã số bài hát: ");
//                    this.songId = scanner.nextLine();
//                } else {
//                    break;
//                }
//            } else {
//                // Nếu mã số bài hát không đáp ứng tiêu chí, yêu cầu nhập lại
//                System.out.println("Mã số bài hát không hợp lệ. Vui lòng nhập mã số bắt đầu bằng 'S' và có ít nhất 4 ký tự.");
//                System.out.print("Mã số bài hát: ");
//                this.songId = scanner.nextLine();
//            }
//        }
//
//        do {
//            System.out.print("Nhập tên bài hát: ");
//            this.songName = scanner.nextLine();
//            if (this.songName.isEmpty()) {
//                System.out.println("Tên bài hát không được để trống. Vui lòng nhập lại.");
//            }
//        } while (this.songName.isEmpty());
//
//        System.out.println("Mô tả bài hát: ");
//        this.descriptions = scanner.nextLine();
//
//        System.out.print("Nhập tên ca sĩ: ");
//        String singerName = scanner.nextLine();
//        this.singer = new Singer(singerName);
//
//        do {
//            System.out.print("Nhập tên người sáng tác: ");
//            this.songWriter = scanner.nextLine();
//            if (this.songWriter.isEmpty()) {
//                System.out.println("Tên người sáng tác không được để trống. Vui lòng nhập lại.");
//            }
//        } while (this.songWriter.isEmpty());
//
//        this.createdDate = new Date();
//
//        System.out.print("Trạng thái bài hát (true/false): ");
//        this.songStatus = scanner.nextBoolean();
//    }
//

}
//
//package ra.model;
//
//import java.text.ParseException;
//import java.util.Date;
//import java.util.Scanner;
//
//public class Song {
//    public static String songId;
//    //    public static String songId;
//    private String songName, songWriter, descriptions;
//    private Singer singer;
//    private Date createdDate;
//    private boolean songStatus;
//    private Scanner scanner;
//
//    public Song(String songId, String songName, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
//        this.songId = songId;
//        this.songName = songName;
//        this.descriptions = descriptions;
//        this.singer = singer;
//        this.songWriter = songWriter;
//        this.createdDate = createdDate;
//        this.songStatus = songStatus;
//        this.scanner = new Scanner(System.in);
//    }
//
//    public Song() {
//        this.scanner = new Scanner(System.in);
//    }
//
//    // Getters and setters
//    public static String getSongId() {
//        return songId;
//    }
//    public void setSongId(String songId) {
//        this.songId = songId;
//    }
//
//    public String getSongName() {
//        return songName;
//    }
//    public void setSongName(String songName) {
//        this.songName = songName;
//    }
//
//    public String getDescriptions() {
//        return descriptions;
//    }
//    public void setDescriptions(String descriptions) {
//        this.descriptions = descriptions;
//    }
//
//    public Singer getSinger() {
//        return singer;
//    }
//    public void setSinger(Singer singer) {
//        this.singer = singer;
//    }
//
//    public String getSongWriter() {
//        return songWriter;
//    }
//    public void setSongWriter(String songWriter) {
//        this.songWriter = songWriter;
//    }
//
//    public Date getCreatedDate() {
//        return createdDate;
//    }
//    public void setCreatedDate(Date createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public boolean isSongStatus() {
//        return songStatus;
//    }
//    public void setSongStatus(boolean songStatus) {
//        this.songStatus = songStatus;
//    }
//
//    @Override
//    public String toString() {
//        return "Song{" +
//                "songId='" + songId + '\'' +
//                ", songName='" + songName + '\'' +
//                ", descriptions='" + descriptions + '\'' +
//                ", singer=" + singer +
//                ", songWriter='" + songWriter + '\'' +
//                ", createdDate=" + createdDate +
//                ", songStatus=" + songStatus +
//                '}';
//    }
//
//    // Method to input data
////    public void inputDataSong() throws ParseException {
////        System.out.print("Mã số bài hát: ");
////        this.songId = scanner.nextLine();
////
////        // Validate song ID
////        if (this.songId == null || this.songId.isEmpty()) {
////            System.out.println("Mã số bài hát không được để trống.");
////            return;
////        }
////
////        if (this.songId.length() < 4 || this.songId.charAt(0) != 'S') {
////            System.out.println("Mã số bài hát không hợp lệ. Vui lòng nhập mã số bắt đầu bằng 'S' và có ít nhất 4 ký tự.");
////            return;
////        }
////
////        // Other input data validation goes here...
////
////        System.out.print("Nhập tên bài hát: ");
////        this.songName = scanner.nextLine();
////
////        // Other input data goes here...
////    }
