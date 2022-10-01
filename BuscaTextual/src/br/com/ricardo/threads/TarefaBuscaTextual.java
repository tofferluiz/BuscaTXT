package br.com.ricardo.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TarefaBuscaTextual implements Runnable {

	private String nomeArquivo;
	private String nomePessoa;

	public TarefaBuscaTextual(String nomeArquivo, String nomePessoa) { //ctrl+1 gera o atributo da classe
		this.nomeArquivo = nomeArquivo;
		this.nomePessoa = nomePessoa;
		
	}

	@Override
	public void run() {
		
		try {
			
	Scanner scan = new Scanner(new File(nomeArquivo));
	int numeroLinha = 1;
	
	  while(scan.hasNextLine()){//enquanto houer uma proxima linha
		 String linha = scan.nextLine();
		 
		 if(linha.toLowerCase().contains(nomePessoa .toLowerCase())){//fazendo a consulta pra ser indiferente 
			                                                         //maiuscula e minuscula
			 System.out.println(nomeArquivo + " - " + numeroLinha + " - " + linha);
			 
		 }
		 numeroLinha++;
		  
	  }
	
	
	  scan.close();
			
		} catch (FileNotFoundException e) {
			
			throw new RuntimeException(e);
		}

	}

}
