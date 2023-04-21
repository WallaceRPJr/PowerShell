import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Scanner;


// pasta dos arquivos : C:\\Users\\Cliente\\OneDrive\\Documentos\\ProjetosGit\\PowerShell\\Diretorios\\

public class PowerShell {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        String local = "C:\\Users\\walla\\OneDrive\\Documentos\\ProjetosGit\\PowerShell\\Diretorios\\";


        String a = " ";
        String x = "", y;


        while(!a.equals("exit")){
            System.out.print("/>"); 
            a = in.nextLine();

            
            if(a.equals("ver")){
                System.out.println( System.getProperty("os.name") );
            }

            

            if(a.equals("mkdir")){
                System.out.print("/>mkdir ");
                x = in.nextLine();

                if(!x.equals("exit")){

                java.io.File diretorio = new java.io.File(local + x); 

                boolean statusDir = diretorio.mkdir();
                System.out.println("/>" + statusDir); 
                }
            }

            
            
            if(a.equals("rm")){
                System.out.print("/>rm ");
                x = in.nextLine();

                if(!x.equals("exit")){

                    File f = new File(local + x);
                    if ((f.exists()) && (f.isDirectory())) f.delete();

                }
            }


            if(a.equals("cat")){
                System.out.print("/>cat ");
                x = in.nextLine();

                if(!x.equals("exit")){
                        Path caminho = Paths.get(local+x+".txt");
                        try{
                        byte [] texto = Files.readAllBytes(caminho);
                        String ler = new String(texto);
                        System.out.println(ler);

                        }catch(IOException e){
                            System.out.println("Erro em abrir o arquivo");
                        }
                }
            }


            if (a.equals("dir")){
                File file = new File(local);
                File afile[] = file.listFiles();
                int i = 0;
                for(int j = afile.length; i < j; i++){
                    File arq = afile[i];
                    System.out.println(arq.getName());
                }
            }
            

            if(a.equals("mv")){
                System.out.print("/>mv ");
                x = in.nextLine();

                if(!x.equals("exit")){
                    System.out.print("/>mv " + x + " ");
                    y = in.nextLine();
                    if(!y.equals("exit")){
                        File arq = new File(local + x + ".txt");
                        arq.renameTo(new File(local + y + ".txt"));
                        System.out.println("/> Arquivo editado");
                    }
                }
            }


            if(a.equals("edit")){
                System.out.print("/>edit ");
                x = in.nextLine();

                if(!x.equals("exit")){
                    Path caminho = Paths.get(local + x + ".txt");
                    String texto = in.nextLine();
                    byte [] textoEmByte = texto.getBytes();
                    try{
                        Files.write(caminho, textoEmByte);
                        System.out.println("/> Arquivo editado");
                    }catch(Exception e){
                        System.out.println("Erro ao alterar o arquivo");
                    }
                }
            }



            if(a.equals("cp")){
                System.out.print("/>cp ");
                x = in.nextLine();

                if(!x.equals("exit")){
                    System.out.print("/>cp " + x + " ");
                    y = in.nextLine();

                    if(!y.equals("exit")){
                        
                        File arq = new File(local + x + ".txt");
                        File destino = new File(local + y);
                        
                       // nao consegui family
                    }
                }
            }


                if(a.equals("rma")){
                    System.out.print("/>rma ");
                    x = in.nextLine();

                    if(!x.equals("exit")){
                        File file = new File(local + x + ".txt");

                        boolean resposta = file.delete();
                        if(resposta){
                            System.out.println("/> Arquivo deletado");
                        }else System.out.println("/> Falha ao deletar");
                        
                    }
                }

                if(a.equals("mka")){
                    System.out.print("/>mka ");
                    x = in.nextLine();
                    
                    if(!x.equals("exit")){
                        File arq = new File(local + x + ".txt");

                        try{
                            arq.createNewFile();
                            System.out.println("/> Arquivo criado");
                        }catch(Exception e){
                            System.out.println("/> Erro ao criar o arquivo");
                        }
                    }
                }

            }

        }

    }

