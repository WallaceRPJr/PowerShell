import java.io.File;
import java.util.Properties;
import java.util.Scanner;

// pasta dos arquivos : C:\\Users\\Cliente\\OneDrive\\Documentos\\ProjetosGit\\PowerShell\\Diretorios

public class PowerShell {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);


        String a = " ";
        String x , y;


        while(!a.equals("sair")){
            System.out.print("/>"); 
            a = in.nextLine();

            if(a.equals("ver")){
                System.out.println( System.getProperty("os.name") );
            }

            if(a.equals("mv")){
                System.out.print("/>mv ");
                x = in.nextLine();
                if(x.equals("exit")) return;

                System.out.print("/>mv " + x + " ");
                y = in.nextLine();
                if(y.equals("exit")) return;

            }

            if(a.equals("mkdir")){
                System.out.print("/>mkdir ");
                x = in.nextLine();

                if(x.equals("exit")) return;

                java.io.File diretorio = new java.io.File("C:\\Users\\Cliente\\OneDrive\\Documentos\\ProjetosGit\\PowerShell\\Diretorios\\" + x); 

                boolean statusDir = diretorio.mkdir();
                System.out.print(statusDir); 


            }



        }

    }
}
