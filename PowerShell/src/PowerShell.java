import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Scanner;

// pasta dos arquivos : C:\\Users\\Cliente\\OneDrive\\Documentos\\ProjetosGit\\PowerShell\\Diretorios

public class PowerShell {

    public static String path = "C:\\Users\\Cliente\\OneDrive\\Documentos\\ProjetosGit\\PowerShell\\Diretorios\\";
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String a = " ";
        String x, y;

        while (!a.equals("sair")) {
            System.out.print("/>");
            a = in.nextLine();

            if (a.equals("ver")) {
                System.out.println(System.getProperty("os.name"));
            }

            if (a.equals("mv")) {
                System.out.print("/>mv ");
                x = in.nextLine();
                if (x.equals("exit"))
                    return;

                System.out.print("/>mv " + x + " ");
                y = in.nextLine();
                if (y.equals("exit"))
                    return;

            }

            if (a.equals("mkdir")) {
                System.out.print("/>mkdir ");
                x = in.nextLine();

                if (x.equals("exit"))
                    return;

                java.io.File diretorio = new java.io.File(
                       path + x);

                boolean statusDir = diretorio.mkdir();
                System.out.print(statusDir);

            }

            if (a.equals("cat")) {
                System.out.print("/>cat ");
                x=in.nextLine();
                String data = "";
                data = new String(Files.readAllBytes(Paths
                        .get(path + x+".txt")));
                System.out.println(data);
            }

            if (a.equals("edit")) {
                System.out.print("/>edit ");
                x=in.nextLine();
                String text = "cu";
                //path = System.getProperty("user.dir"); //Pasta padrão do código java
                //System.out.println(path);
                File file = new File(path + x+".txt");
                boolean result;

                // checking if the file exists, if not it creates the file
                try {
                    result = file.createNewFile();
                    if (result) {
                        System.out.println("File does not exist. File created at " + file.getCanonicalPath());
                    } else {
                        System.out.println("File already exists at " + file.getCanonicalPath());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }

                System.out.println("Type what should be writen in the document");
                text = in.nextLine();               

                FileOutputStream fos = new FileOutputStream(file, false);
                byte[] b = text.getBytes();
                fos.write(b);

            }

        }

    }
}
