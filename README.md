# README.md
Luce
PT/EN: Plataforma de streaming de vídeo desenvolvida com microserviços em Spring Boot. Oferece autenticação, upload, busca e reprodução de vídeos sob demanda. Projeto acadêmico da disciplina Engenharia de Software 2. Video streaming platform built with Spring Boot microservices.

📺 Plataforma de Streaming de Vídeo / Video Streaming Platform
Projeto desenvolvido como parte da disciplina Engenharia de Software 2, utilizando arquitetura de microserviços com Spring Boot.

Project developed as part of the Software Engineering 2 course, using microservices architecture with Spring Boot.

🧩 Etapa 1: Iniciação e Planejamento / Step 1: Project Initiation and Planning
1.1 Domínio e Escopo / Domain and Scope
Domínio:
Entretenimento digital — serviços de streaming de vídeo sob demanda.

Domain:
Digital entertainment — on-demand video streaming services.

Escopo do Projeto:
Desenvolver uma plataforma de streaming que permita:

Cadastro e autenticação de usuários
Upload e visualização de vídeos
Busca e organização de conteúdos
Avaliações e interações com os vídeos
Administração da plataforma
Project Scope:
Develop a video streaming platform that allows:

User registration and authentication
Video upload and playback
Content search and categorization
Ratings and user interactions
Platform administration
1.2 Requisitos / Requirements
✅ Requisitos Funcionais / Functional Requirements
RF01 / FR01: O usuário pode se cadastrar e realizar login.
Users can register and log in.

RF02 / FR02: O usuário pode assistir aos vídeos da plataforma.
Users can watch videos available on the platform.

RF03 / FR03: O sistema permite upload de vídeos (usuário criador/admin).
The system allows video uploads (creator/admin users).

RF04 / FR04: O usuário pode buscar vídeos por título, gênero ou palavra-chave.
Users can search for videos by title, genre, or keywords.

RF05 / FR05: O usuário pode favoritar vídeos para acesso rápido.
Users can favorite videos for quick access.

⚙️ Requisitos Não Funcionais / Non-Functional Requirements
RNF01 / NFR01: Alta disponibilidade e escalabilidade.
High availability and scalability.

RNF02 / NFR02: Arquitetura baseada em microserviços RESTful.
RESTful microservices architecture.

RNF03 / NFR03: Backend desenvolvido em Spring Boot.
Backend developed with Spring Boot.

RNF04 / NFR04: Armazenamento de vídeos em serviço escalável (ex: AWS S3 ou similar).
Video storage in a scalable service (e.g., AWS S3 or similar).

1.3 Modelos de Processos / Process Models
Metodologia / Methodology:
Utilização de metodologias ágeis com foco em Scrum, incluindo:
Agile methodology with a focus on Scrum, including:

Reuniões semanais (sprints) / Weekly sprints
Quadro de tarefas (Kanban) / Task board (Kanban)
Entregas incrementais e testes contínuos / Incremental deliveries and continuous testing
Microserviços Propostos / Proposed Microservices:

Microserviço / Microservice	Responsabilidade / Responsibility
Auth-Service	Login, cadastro, autenticação (JWT) / Auth (JWT)
User-Service	Perfil e listas de usuário / User profiles & lists
Video-Service	Upload, armazenamento, streaming / Video handling
Catalog-Service	Indexação, busca e categorias / Search & categories
Review-Service	Avaliações e comentários / Ratings and feedback
Gateway-Service	Roteamento entre serviços / API Gateway
Config-Service	Configuração centralizada / Centralized config


O ChatGPT disse:
