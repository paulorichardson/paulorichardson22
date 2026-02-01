import express from 'express';
import cors from 'cors';
import morgan from 'morgan';
import { v4 as uuidv4 } from 'uuid';

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());
app.use(morgan('dev'));

const usuarios = [
  {
    id: uuidv4(),
    nome: 'João Santos',
    cpf: '22222222222',
    perfil: 'servidor',
    municipio_nome: 'Prefeitura de Tanque Novo',
    servidor_id: 'srv-1'
  },
  {
    id: uuidv4(),
    nome: 'Admin Gerali',
    cpf: '00000000000',
    perfil: 'admin_municipal',
    municipio_nome: 'GERALI'
  }
];

const servidores = [
  {
    id: 'srv-1',
    nome: 'João Santos',
    cpf: '222.222.222-22',
    matricula: 'M12345',
    secretaria: 'Saúde',
    limite_mensal: 600.0
  },
  {
    id: 'srv-2',
    nome: 'Maria Souza',
    cpf: '111.111.111-11',
    matricula: 'M54321',
    secretaria: 'Educação',
    limite_mensal: 500.0
  }
];

const tickets = [];

const generateTicketCode = () => `TKT-${new Date().getFullYear()}-${Math.floor(Math.random() * 90000) + 10000}-GERALI`;

app.post('/api/auth/login', (req, res) => {
  const { cpf, senha } = req.body;
  if (!cpf || !senha) {
    return res.status(400).json({ sucesso: false, erro: 'CPF e senha são obrigatórios.' });
  }

  const usuario = usuarios.find((item) => item.cpf === cpf);
  if (!usuario) {
    return res.status(401).json({ sucesso: false, erro: 'Usuário não encontrado.' });
  }

  return res.json({
    sucesso: true,
    token: 'mock-jwt-token',
    usuario
  });
});

app.post('/api/tickets/gerar', (req, res) => {
  const { servidor_id, tipo } = req.body;
  const servidor = servidores.find((item) => item.id === servidor_id);

  if (!servidor) {
    return res.status(404).json({ sucesso: false, erro: 'Servidor não encontrado.' });
  }

  const ticket = {
    id: uuidv4(),
    codigo_ticket: generateTicketCode(),
    servidor_id,
    servidor_nome: servidor.nome,
    cpf_mascarado: servidor.cpf,
    valor_autorizado: 30.0,
    tipo: tipo || 'diario',
    data_geracao: new Date().toISOString(),
    data_validade: new Date(Date.now() + 7 * 24 * 60 * 60 * 1000).toISOString(),
    status: 'ativo',
    usado: false,
    data_uso: null,
    credenciado_nome: null
  };

  tickets.push(ticket);

  return res.json({ sucesso: true, ticket, erro: null });
});

app.post('/api/tickets/validar', (req, res) => {
  const { codigo, credenciado_id } = req.body;
  const ticket = tickets.find((item) => item.codigo_ticket === codigo);

  if (!ticket) {
    return res.status(404).json({ sucesso: false, mensagem: 'Ticket não encontrado.' });
  }

  if (ticket.usado) {
    return res.status(409).json({ sucesso: false, mensagem: 'Ticket já utilizado.' });
  }

  ticket.usado = true;
  ticket.data_uso = new Date().toISOString();
  ticket.status = 'usado';
  ticket.credenciado_nome = credenciado_id ? `Credenciado ${credenciado_id}` : 'Credenciado Demo';

  return res.json({
    sucesso: true,
    mensagem: 'Ticket validado com sucesso.',
    servidor_nome: ticket.servidor_nome,
    servidor_cpf: ticket.cpf_mascarado,
    valor: ticket.valor_autorizado,
    data_hora: ticket.data_uso
  });
});

app.get('/api/tickets/servidor/:id', (req, res) => {
  const { id } = req.params;
  const data = tickets.filter((ticket) => ticket.servidor_id === id);
  return res.json(data.map((ticket) => ({ sucesso: true, ticket, erro: null })));
});

app.get('/api/relatorios/dashboard', (_req, res) => {
  const ticketsHoje = tickets.filter((ticket) => {
    const ticketDate = new Date(ticket.data_geracao);
    const today = new Date();
    return (
      ticketDate.getDate() === today.getDate() &&
      ticketDate.getMonth() === today.getMonth() &&
      ticketDate.getFullYear() === today.getFullYear()
    );
  });

  return res.json({
    total_servidores: servidores.length,
    total_credenciados: 10,
    tickets_hoje: ticketsHoje.length,
    consumo_mensal: 45000.0
  });
});

app.get('/api/servidores', (_req, res) => {
  res.json(servidores);
});

app.get('/health', (_req, res) => {
  res.json({ status: 'ok' });
});

app.listen(PORT, () => {
  console.log(`GERALI Web API running on port ${PORT}`);
});
