import java.util.Scanner;

class Main {

 
  /* Aqui criamos uma variavel global. Global significa que o elemento pode ser acessado por qualquer método. Para tornar global, utilizamos a palavra static.
  */
  static double saldo = 100;
  static String nome;

  /*  Um método simples que só exibe uma mensagem ao usuário e em seguida chama a função principal. */
  public static void ver_saldo() {

    Scanner ver = new Scanner(System.in);

    System.out.println("Informe a senha, por favor:");
    int senha = ver.nextInt();
    
    if(senha == 3589) {
      
      System.out.println("Seu saldo atual é: " + saldo);
      escolha();

    } else {
      System.out.println("Senha incorreta! Tente novamente:");
      ver_saldo();
    }

    ver.close();
    
  }

  /*  Método para receber informado pelo usuário, processar e levar a uma mensagem de sucesso ou a repetição da função */
  public static void fazer_deposito() {

    System.out.println("Qual o valor a ser depositado?");
    Scanner valor = new Scanner(System.in);
    Double deposito = valor.nextDouble();

    // Not a Number
    boolean checaNumero = deposito.isNaN(); // o método isNaN retorna checa se o valor informado é um Não-Número e retorna verdadeiro ou falso.

    if (checaNumero || deposito <= 0) {
      System.out.println("Por favor, informe um número válido:");
      fazer_deposito();
    } else {
      saldo += deposito;
      System.out.println("Seu saldo atual é " + saldo);
      escolha();
    }

    valor.close();
  }

  public static void fazer_saque() {

    Scanner ver = new Scanner(System.in);

    System.out.println("Informe a senha, por favor:");
    int senha = ver.nextInt();
    
    if(senha == 3589) {

    System.out.println("Qual o valor para saque?");
    
    Double saque = ver.nextDouble();

    boolean checaNumero = saque.isNaN();

    if (checaNumero || saque <= 0) {
      System.out.println("Por favor, informe um número válido:");
      fazer_saque();
    } else if(checaNumero || saque > saldo){
      System.out.println("Operação não autorizada.");
      fazer_saque();
    } else {
      saldo -= saque;
      System.out.println("Seu saldo atual é " + saldo);
      escolha();
      ver.close();
    }
  } else {
    System.out.println("Senha incorreta! Tente novamente:");
      fazer_saque();
  }
  }

  public static void ver_extrato () {
    Scanner ver = new Scanner(System.in);

    System.out.println("Informe a senha, por favor:");
    int senha = ver.nextInt();
    
    if(senha == 3589) {

    System.out.println("Cartão de Débito    R$20,00 \nCartão de Crédito   R$78,58 \nCartão de Crédito   R$25,00 \nCartão de Débito    R$40,00");
   
    escolha();

    } else {
      
      System.out.println("Senha incorreta! Tente novamente:");
      ver_extrato();
    
    }
    ver.close();
  }

  public static void tranferencia() {
    
    Scanner ver = new Scanner(System.in);

    System.out.println("Informe a senha, por favor:");
    int senha = ver.nextInt();
    
    if(senha == 3589) {

    System.out.println("Qual o número da conta na qual irá transferir o valor?");
    Double numeroconta = ver.nextDouble();

    boolean checarNumero = numeroconta.isNaN();

    if(checarNumero == true|| numeroconta <= 0 ) {
      System.out.println("Valor inválido. Por favor, informe um número válido:");
      tranferencia();
    }

    System.out.print("Qual é o valor a ser transferido?");
    Double valor = ver.nextDouble();

    if (valor > saldo || valor <= 0) {
      System.out.println("Operação não autorizada.");
      tranferencia();
    }

    saldo -= valor;
    System.out.println("Seu saldo atual é " + saldo);
    escolha();

  } else {
    System.out.println("Senha incorreta! Tente novamente:");
    tranferencia();
  }ver.close();
}

  public static void erro() {
    System.out.println("Por favor, informe um número entre 1 e 6");
    escolha();
  }

  public static void sair() {
    
    System.out.println("Você deseja sair? S/N");

    Scanner sair = new Scanner(System.in);
    String escolha = sair.nextLine();

    if (escolha.equals("S")) {
      System.out.println(nome +", foi um prazer ter ver por aqui!.");
      System.exit(0);
    } else if (escolha.equals("N")) {
      escolha();;
    } else {
      System.out.println("Desculpe, mas não compreendi.");
      sair();
    }

    sair.close();

  }

  public static void escolha() {

    Scanner in = new Scanner(System.in);

    System.out.println("Selecione uma opção \n1.) Saldo \n2.) Extrato \n3.) Saque \n4.) Depósito \n5.) Tranferência\n6.) Sair");

   
    int escolha = in.nextInt();

    switch (escolha) {
      case 1:
        ver_saldo();
      break;

      case 2:
      ver_extrato();
      break;

      case 3:
        fazer_saque();
      break;

      case 4:
      fazer_deposito();
      break;

      case 5:
        tranferencia();
      break;

      case 6:
        sair();;
      break;

      default:
        erro();;
      break;

  }

  in.close();
  }

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);

      System.out.println(("Insira o seu nome abaixo, por favor:"));
      nome = in.nextLine();
      System.out.println("Olá " + nome + ", é um prazer te ver por aqui!");

      escolha();
      in.close();
      
  }

}

