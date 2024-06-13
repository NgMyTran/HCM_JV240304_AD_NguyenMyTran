package ra.service;

import ra.model.Singer;
import java.util.Arrays;
import java.util.Scanner;

public class SingerService {
    private Singer[] singers;

    public SingerService(Singer[] singers) {
        this.singers = singers;
    }

    public SingerService() {
        this.singers = new Singer[0];
    }

    public Singer[] searchSingersByName(String name) {
        int count = 0;
        for (Singer singer : singers) {
            if (singer.getSingerName().equalsIgnoreCase(name)) {
                count++;
            }
        }
        Singer[] foundSingers = new Singer[count];
        int index = 0;
        for (Singer singer : singers) {
            if (singer.getSingerName().equalsIgnoreCase(name)) {
                foundSingers[index] = singer;
                index++;
            }
        }
        return foundSingers;
    }

    public Singer[] searchSingersByGenre(String genre) {
        int count = 0;
        for (Singer singer : singers) {
            if (singer.getGenre().equalsIgnoreCase(genre)) {
                count++;
            }
        }
        Singer[] foundSingers = new Singer[count];
        int index = 0;
        for (Singer singer : singers) {
            if (singer.getGenre().equalsIgnoreCase(genre)) {
                foundSingers[index] = singer;
                index++;
            }
        }
        return foundSingers;
    }

    public void addSinger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng ca sĩ cần thêm: ");
        int numberOfSongs = scanner.nextInt();
        System.out.println("Nhập thông tin của ca sĩ mới:");

        String name = null;
        int age = 0;
        String nationality = null;
        String genre = null;
        boolean gender = false;
        for (int i = 0; i < numberOfSongs; i++) {
            while (true) {
                System.out.print("Tên ca sĩ " + (i + 1) + ": ");
                name = scanner.nextLine();
                if (name != null && !name.trim().isEmpty()) {
                    break;
                } else {
                    System.out.println("Tên ca sĩ không được để trống. Vui lòng nhập: ");
                }
            }
            while (true) {
                System.out.print("Tuổi: ");
                if (scanner.hasNextInt()) {
                    age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    break;
                } else {
                    System.out.println("Tuổi phải là một số nguyên. Vui lòng nhập lại.");
                    scanner.nextLine(); // Consume invalid input
                }
            }
            System.out.print("Quốc gia: ");
            nationality = scanner.nextLine();
            System.out.print("Thể loại âm nhạc: ");
            genre = scanner.nextLine();
            while (true) {
                System.out.print("Giới tính (Male/Female): ");
                String genderInput = scanner.nextLine();
                if (genderInput.equalsIgnoreCase("Male")) {
                    gender = true;
                    break;
                } else if (genderInput.equalsIgnoreCase("Female")) {
                    gender = false;
                    break;
                } else {
                    System.out.println("Giới tính không hợp lệ. Vui lòng nhập lại.");
                }
            }

            // Create and add the new singer
            Singer newSinger = new Singer(name, age, nationality, genre, gender);
            singers = Arrays.copyOf(singers, singers.length + 1);
            singers[singers.length - 1] = newSinger;
        }
        System.out.println("Ca sĩ mới đã được thêm vào hệ thống.");
    }

    public void updateSinger(int id) {
        boolean found = false;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < singers.length; i++) {
            if (singers[i].getSingerId() == id) {
                System.out.println("Nhập thông tin mới cho ca sĩ:");
                System.out.print("Tên ca sĩ: ");
                singers[i].setSingerName(scanner.nextLine());
                System.out.print("Tuổi: ");
                singers[i].setAge(scanner.nextInt());
                scanner.nextLine(); // Consume newline
                System.out.print("Quốc gia: ");
                singers[i].setNationality(scanner.nextLine());

                // Loop until a valid gender is entered
                boolean validGender = false;
                while (!validGender) {
                    System.out.print("Giới tính (Nam/Nữ): ");
                    String genderInput = scanner.nextLine();
                    if (genderInput.equalsIgnoreCase("Nam")) {
                        singers[i].setGender(true);
                        validGender = true;
                    } else if (genderInput.equalsIgnoreCase("Nữ")) {
                        singers[i].setGender(false);
                        validGender = true;
                    } else {
                        System.out.println("Giới tính không hợp lệ. Vui lòng nhập lại.");
                    }
                }

                System.out.print("Thể loại âm nhạc: ");
                singers[i].setGenre(scanner.nextLine());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy ca sĩ có mã số " + id);
        } else {
            System.out.println("Cập nhật thông tin ca sĩ thành công.");
        }
    }

    public void deleteSinger(int id) {
        boolean found = false;
        for (int i = 0; i < singers.length; i++) {
            if (singers[i].getSingerId() == id) {
                System.arraycopy(singers, i + 1, singers, i, singers.length - 1 - i);
                singers = Arrays.copyOf(singers, singers.length - 1); // Reduce the size of the array by 1
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy ca sĩ có mã số " + id);
        } else {
            System.out.println("Xóa ca sĩ thành công.");
        }
    }

    public void displayAllSingers() {
        if (singers.length == 0) {
            System.out.println("Không có ca sĩ nào được lưu trữ.");
        } else {
            System.out.println("Danh sách các ca sĩ:");
            for (Singer singer : singers) {
                System.out.println(singer);
            }
        }
    }

    public Singer[] getAllSingers() {
        return singers;
    }
}

