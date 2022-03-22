import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Acoes {
    public static void main(String[] args) throws IOException {
        ArrayList<Dados> contas = new ArrayList<Dados>();
        Scanner entrada = new Scanner(System.in);

        String agencia;
		String conta;
		String telefone;
		String nome;
        double saldo;
        boolean execute;

        execute = true;

        while (execute) {
            
            System.out.println("Bem vindo ao plataforma de cadastros usuários correntistas!");
            System.out.println("1 - Cadastrar Clientes");
			System.out.println("2 - Listar Clientes");
			System.out.println("3 - Gravar em arquivo texto");
			System.out.println("4 - Consultar arquivo texto");
			System.out.println("5 - Sair");
			System.out.println("==================================");
			System.out.println("Escolha a opção desejada : ");

            String opcao = entrada.nextLine();

            if (opcao == 5){
                System.out.println("Saindo a plataforma, Obrigado!");
            } else {
                switch (opcao) {
                    case "1": {
                        System.out.println("Digite sua agência: ");
						agencia = entrada.nextLine();
						System.out.println("Digite sua conta: ");
						conta = entrada.nextLine();
						System.out.println("Digite seu nome: ");
						nome = entrada.nextLine();							
						System.out.println("Digite seu tefelone: ");
						telefone = entrada.nextLine();
						System.out.println("Digite o saldo da conta: ");
						saldo = entrada.nextDouble();
						Dados c = new Dados();
						c.setAgencia(agencia);
						c.setConta(conta);
						c.setNome(nome);							
						c.setTelefone(telefone);
						c.setSaldo(saldo);
						System.out.println("Cadastro adicionado !!!");
                    }
                    break;
                    case "2": {
                        if (contas.isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado!");
                        }else{
                            for (Dados adicionado:contas) {
                                System.out.println(adicionado);
                            }
                        }
                        break;
                    }
                    case "3": {
                        // arquivo no diretorio local da maquina
                        FileWriter fw = new FileWriter("c:\\clientes.txt");
                        for (Dados adicionado:contas) {
                            gravarArquivo.println(adicionado);
                        }

                        arquivo.close();
                        System.out.println("Dados salvo com sucesso!!!");
						System.out.println("Local salvo: C:\\clientes.txt");
						System.out.println("Nome do arquivo: dados_de_correntistas");
						break;
                    }
                    case "4": {
                        String nomeArquivo="C:\\clientes.txt"; 
						String linha = "";
						File arq = new File(nomeArquivo);
                   
							if(arq.exists()) {					
								
								try {
									FileReader reader = new FileReader(nomeArquivo);
									
									BufferedReader leitor = new BufferedReader(reader);
									while(true) {
										linha = leitor.readLine();
										System.out.println(linha);
										if(linha == null)
											break;
									}
								}
								catch(Exception erro) {}
							} else {
								System.out.println("Arquivo Nao Existe!");
							} 
							break;
						}
						case "5": {
							System.out.println("Saindo...");
							execute = false;
							break;
						}
						default:
							System.out.println("Opção inválida. Tente novamente!");
						}
					}
						entrada.close();
				}
            }
        }