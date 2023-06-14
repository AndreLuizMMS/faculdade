// O nome do arquivo deve terminar com .js, ele foi modificado para .txt por questões de segurança do Teams

// Para rodar o programa é necessário ter o node instalado e rodar os comandos:
// npm i
// node André_Luiz_Morais_2.js

// importação de bibliotecas
const sc = require('prompt-sync')();
const mysql = require('mysql2');

// função que padroniza a unidade do produto
function unidade() {
  console.log('Unidades :');
  console.log('1. Unitário: un');
  console.log('2. Miligramas: ml');
  console.log('3. Gramas: g');
  let opc = sc('\nSelecione uma unidade: ');
  switch (opc) {
    case '1':
      return 'un';
    case '2':
      return 'ml';
    case '3':
      return 'g';
    default:
      return 'un';
  }
}

// funções que interagem com o banco de dados
function AddProd({ nome, unid, valorUnit }) {
  return new Promise((resolve, reject) => {
    const sql = `INSERT INTO tab_produto (nome_produto, unidade, valor_unit) VALUES ('${nome}', '${unid}', '${valorUnit}')`;

    con.query(sql, (err, result) => {
      if (err) {
        console.log('deu ruim', err);
        reject(err);
        return;
      }
      console.log('Produto adicionado com sucesso!');
      resolve(result);
    });
  });
}

function listarProd() {
  return new Promise((resolve, reject) => {
    const sql = `SELECT * FROM tab_produto`;

    con.query(sql, (err, result) => {
      if (err) {
        console.log('Erro: ', err);
        reject(err);
        return;
      }

      result.forEach(prod => {
        console.log(`Nome: ${prod.nome_produto}`);
        console.log(`Unidade: ${prod.unidade}`);
        console.log(`Valor: ${prod.valorUnit} $`);
      });

      resolve(result);
    });
  });
}

function listarProd() {
  const sql = `SELECT * FROM tab_produto`;

  con.query(sql, (err, result) => {
    if (err) {
      console.log('Erro: ', err);
      return;
    }
    result.forEach(prod => {
      console.log(`Nome: ${prod.nome_produto}`);
      console.log(`Unidade: ${prod.unidade}`);
      console.log(`Valor: ${prod.valor_unit} $`);
    });
  });
}

function modificProd({ nome, unid, valorUnit }) {
  const sql = `UPDATE tab_produto SET unidade = '${unid}', valor_unit = '${valorUnit}' WHERE nome_produto = '${nome}'`;

  con.query(sql, (err, result) => {
    if (err) {
      console.log('deu ruim', err);
      return;
    }
    console.log('Produto modificado com sucesso!');
  });
}

function deletProd(nome) {
  const sql = `DELETE FROM tab_produto WHERE nome_produto = '${nome}'`;

  con.query(sql, (err, result) => {
    if (err) {
      console.log('deu ruim', err);
      return;
    }
    console.log('Produto deletado com sucesso!');
  });
}

// função que exibe o menu
const menu = async () => {
  let opt;
  console.log(' 1. Adicionar Produto');
  console.log(' 2. Listar Produtos');
  console.log(' 3. Modificar Produto');
  console.log(' 4. Deletar Produto');

  let prod = {};
  opt = sc('\nSelecione uma opção:');

  switch (opt) {
    case '1':
      // Adicionar Produto
      prod.nome = sc('Nome do produto: ');
      prod.unid = unidade();
      prod.valorUnit = sc('Valor unitário: ');
      await AddProd(prod);
      prod = {};
      return;
    case '2':
      // Listar Produtos
      await listarProd();
      return;
    case '3':
      // Modificar Produto
      prod.nome = sc('Nome do produto a ser modificado: ');
      prod.unid = unidade();
      prod.valorUnit = sc('Valor unitário: ');
      modificProd(prod);
      prod = {};
      return;
    case '4':
      // Deletar Produto
      deletProd(sc('Nome do produto a ser deletado: '));
      return;
    default:
      console.log('Opção inválida');
  }
};

// conexão com o banco de dados
const con = mysql.createConnection({
  host: 'localhost',
  user: 'deds',
  password: 'password',
  database: 'AED_1_Ronaldo'
});
con.connect(function (err) {
  if (err) throw err;
  console.log('Connected!');
  menu();
});
