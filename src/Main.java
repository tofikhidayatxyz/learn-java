import java.util.Scanner;
import com.property.controller.PlaylistController;

public class Main {
    public static void main(String[] args) {
        // prepare
        int prompt = 1;
        Scanner scan = new Scanner(System.in);
        // initialize playlist
        PlaylistController playlist = new PlaylistController();

        // run seeders
        playlist.runSeed();
        // action
        while (prompt > 0 && prompt < 7) {
            System.out.println("========  Daftar menu =======");
            System.out.println("1. Tampilkan Data Playlist");
            System.out.println("2. Tambah Data Playlist");
            System.out.println("3. Hapus Data Playlist");
            System.out.println("4. Hapus semua Playlist");

            System.out.print("\nPilih menu : ");

            try {
                prompt = Integer.parseInt(scan.nextLine());
            } catch(Exception e) {
                prompt = 0;
                break;
            }

            switch (prompt) {
                case 1 -> playlist.viewAll();
                case 2 -> playlist.storePlaylist(scan);
                case 3 -> playlist.deletePlaylist(scan);
                case 4 -> playlist.deleteAll(scan);
                default -> prompt = 0;
            }
        }
        System.out.println("========  End program  ======== ");
    }
}
