# 🚗 Primeiro Projeto – Cadastro de Marcas e Modelos de Carros

Aplicação desktop em **Java (Swing)** para cadastro de marcas e modelos de carros, desenvolvida como projeto de estudo de Programação Orientada a Objetos e do padrão **MVC**.

> ⚠️ **Status:** em desenvolvimento. Veja a seção [Status e próximos passos](#-status-e-próximos-passos).

## 📋 Funcionalidades

- [x] Estrutura de classes de domínio (`Marca`, `Modelo`, `Carro`)
- [x] Armazenamento em memória (`BancoDados`)
- [x] Tela de cadastro de marca (nome e país) com tabela de listagem
- [x] Operações de salvar, listar, buscar e excluir marcas no controller
- [ ] Integração da tela inicial com a tela de marcas
- [ ] Cadastro de modelos
- [ ] Persistência de dados (arquivo ou banco de dados)

## 🗂️ Estrutura do projeto

```
Primeiro_Projeto/
├── src/
│   ├── model/
│   │   ├── BancoDados.java      # Listas estáticas que simulam um banco de dados
│   │   ├── Marca.java           # Entidade Marca (nome, país, modelos)
│   │   ├── Modelo.java          # Entidade Modelo (nome, marca)
│   │   └── Carro.java           # Entidade Carro (a implementar)
│   ├── view/
│   │   ├── TelaInicio.java      # Janela principal (ponto de entrada: main)
│   │   └── TelaMarca.java       # Diálogo de cadastro de marcas
│   └── controller/
│       └── MarcaController.java # Regras de negócio para marcas
├── .classpath / .project        # Configuração do Eclipse
└── .settings/                   # Preferências do Eclipse
```

## 🛠️ Tecnologias

- Java 21
- Java Swing (interface gráfica)
- Eclipse IDE

## ▶️ Como executar

### Pelo Eclipse
1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/Primeiro_Projeto.git
   ```
2. No Eclipse: **File → Import → Existing Projects into Workspace** e selecione a pasta clonada.
3. Execute a classe `view.TelaInicio` (**Run As → Java Application**).

### Pela linha de comando
Requer JDK 21 ou superior.

```bash
mkdir -p bin
javac -d bin $(find src -name "*.java")
java -cp bin view.TelaInicio
```

## 🧠 Conceitos praticados

- Programação Orientada a Objetos (encapsulamento, construtores, `toString`)
- Padrão MVC (Model, View, Controller)
- Interfaces gráficas com Swing (`JFrame`, `JDialog`, `JTable`, `DefaultTableModel`)
- Coleções (`ArrayList`) e expressões lambda

## 🚧 Status e próximos passos

- Ligar o botão **Cadastrar Marca** da `TelaInicio` para abrir a `TelaMarca`.
- Corrigir `TelaMarca`: os botões **Editar** e **Excluir** estão registrando ação no botão **Salvar**, e `contentPane` é usado antes de ser inicializado em `configurarJanela()`.
- Implementar `Carro` e o cadastro de `Modelo`.
- Adicionar persistência de dados.

## 👤 Autor

**Anthoni** – [GitHub](https://github.com/AnthoniVetter)

## 📄 Licença

Projeto com fins educacionais. Defina a licença de sua preferência (ex.: MIT).
