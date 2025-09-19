# 📦 Sistema de Controle de Estoque

Projeto desenvolvido em **Java + Spring Boot** para gerenciamento de estoque.  
Inclui cadastro de produtos, fornecedores e movimentações de entrada/saída.  

## 🚀 Tecnologias
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database (em memória)
- Swagger UI (documentação da API)

## ⚙️ Funcionalidades
- Cadastro de **Produtos**
- Cadastro de **Fornecedores**
- Registro de **Movimentações de Estoque**
- Relatório de produtos em falta
- Upload de **CSV** para importar produtos em lote

## ▶️ Como rodar
```bash
mvn clean spring-boot:run
```

Acesse:
- API: `http://localhost:8080`
- Swagger: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console` (usuário: `sa`, sem senha)

## 📄 Exemplo CSV para importação
```csv
nome,descricao,preco,quantidadeEstoque
Parafuso M6,Parafuso galvanizado 6mm,0.5,100
Porca M6,Porca zincada M6,0.2,200
Arruela M6,Arruela zincada M6,0.1,300
```

---

👨‍💻 Desenvolvido por [Gabriel de Freitas Brito](https://www.linkedin.com/in/gfreitasb)
