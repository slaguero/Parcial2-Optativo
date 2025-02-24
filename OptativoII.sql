PGDMP                  
    {        
   OptativoII    16.0    16.0 !    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16394 
   OptativoII    DATABASE     �   CREATE DATABASE "OptativoII" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Paraguay.1252';
    DROP DATABASE "OptativoII";
                postgres    false            �            1259    16395    ciudad    TABLE     �   CREATE TABLE public.ciudad (
    id integer NOT NULL,
    ciudad character varying(30) NOT NULL,
    departamento character varying(30) NOT NULL,
    postal integer NOT NULL
);
    DROP TABLE public.ciudad;
       public         heap    postgres    false            �            1259    16398    ciudad_id_seq    SEQUENCE     �   CREATE SEQUENCE public.ciudad_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.ciudad_id_seq;
       public          postgres    false    215            �           0    0    ciudad_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.ciudad_id_seq OWNED BY public.ciudad.id;
          public          postgres    false    216            �            1259    16399    cliente    TABLE     �   CREATE TABLE public.cliente (
    idpersona integer,
    fechaingreso date,
    calificacion character varying(30),
    estado character varying(30),
    id integer NOT NULL
);
    DROP TABLE public.cliente;
       public         heap    postgres    false            �            1259    16402    cliente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cliente_id_seq;
       public          postgres    false    217            �           0    0    cliente_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;
          public          postgres    false    218            �            1259    16403    cuentas    TABLE     w  CREATE TABLE public.cuentas (
    id integer NOT NULL,
    idcliente integer,
    nrocuenta character varying(30),
    fechaalta date,
    tipocuenta character varying(30),
    estado character varying(30),
    saldo real,
    nrocontrato character varying(30),
    costomantenimiento real,
    promedioacreditacion character varying(30),
    moneda character varying(30)
);
    DROP TABLE public.cuentas;
       public         heap    postgres    false            �            1259    16406    cuentas_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cuentas_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.cuentas_id_seq;
       public          postgres    false    219            �           0    0    cuentas_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.cuentas_id_seq OWNED BY public.cuentas.id;
          public          postgres    false    220            �            1259    16407    movimientos    TABLE     $  CREATE TABLE public.movimientos (
    idmovimiento integer NOT NULL,
    idcuenta integer,
    fechamovimiento date,
    tipomovimiento character varying,
    saldoanterior real,
    saldoactual real,
    montomovimiento real,
    cuentaorigen real,
    cuentadestino real,
    canal real
);
    DROP TABLE public.movimientos;
       public         heap    postgres    false            �            1259    16412    persona_id_seq    SEQUENCE     w   CREATE SEQUENCE public.persona_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.persona_id_seq;
       public          postgres    false            �            1259    16413    persona    TABLE     �  CREATE TABLE public.persona (
    id integer DEFAULT nextval('public.persona_id_seq'::regclass) NOT NULL,
    idciudad integer,
    nombre character varying(30),
    apellido character varying(30),
    tipodocumento character varying(30),
    nrodocumento character varying(30),
    direccion character varying(100),
    email character varying(100),
    celular character varying(30),
    estado character varying(30)
);
    DROP TABLE public.persona;
       public         heap    postgres    false    222            -           2604    16417 	   ciudad id    DEFAULT     f   ALTER TABLE ONLY public.ciudad ALTER COLUMN id SET DEFAULT nextval('public.ciudad_id_seq'::regclass);
 8   ALTER TABLE public.ciudad ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215            .           2604    16418 
   cliente id    DEFAULT     h   ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);
 9   ALTER TABLE public.cliente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217            /           2604    16419 
   cuentas id    DEFAULT     h   ALTER TABLE ONLY public.cuentas ALTER COLUMN id SET DEFAULT nextval('public.cuentas_id_seq'::regclass);
 9   ALTER TABLE public.cuentas ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    220    219            �          0    16395    ciudad 
   TABLE DATA           B   COPY public.ciudad (id, ciudad, departamento, postal) FROM stdin;
    public          postgres    false    215   Z%       �          0    16399    cliente 
   TABLE DATA           T   COPY public.cliente (idpersona, fechaingreso, calificacion, estado, id) FROM stdin;
    public          postgres    false    217   �%       �          0    16403    cuentas 
   TABLE DATA           �   COPY public.cuentas (id, idcliente, nrocuenta, fechaalta, tipocuenta, estado, saldo, nrocontrato, costomantenimiento, promedioacreditacion, moneda) FROM stdin;
    public          postgres    false    219   &       �          0    16407    movimientos 
   TABLE DATA           �   COPY public.movimientos (idmovimiento, idcuenta, fechamovimiento, tipomovimiento, saldoanterior, saldoactual, montomovimiento, cuentaorigen, cuentadestino, canal) FROM stdin;
    public          postgres    false    221   a&       �          0    16413    persona 
   TABLE DATA           �   COPY public.persona (id, idciudad, nombre, apellido, tipodocumento, nrodocumento, direccion, email, celular, estado) FROM stdin;
    public          postgres    false    223   ~&       �           0    0    ciudad_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.ciudad_id_seq', 9, true);
          public          postgres    false    216            �           0    0    cliente_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cliente_id_seq', 4, true);
          public          postgres    false    218            �           0    0    cuentas_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.cuentas_id_seq', 3, true);
          public          postgres    false    220            �           0    0    persona_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.persona_id_seq', 1, true);
          public          postgres    false    222            2           2606    16421    ciudad ciudad_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.ciudad
    ADD CONSTRAINT ciudad_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.ciudad DROP CONSTRAINT ciudad_pkey;
       public            postgres    false    215            4           2606    16423    cliente cliente_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cliente DROP CONSTRAINT cliente_pkey;
       public            postgres    false    217            6           2606    16425    cuentas cuentas_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.cuentas
    ADD CONSTRAINT cuentas_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.cuentas DROP CONSTRAINT cuentas_pkey;
       public            postgres    false    219            8           2606    16427    movimientos movimientos_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY public.movimientos
    ADD CONSTRAINT movimientos_pkey PRIMARY KEY (idmovimiento);
 F   ALTER TABLE ONLY public.movimientos DROP CONSTRAINT movimientos_pkey;
       public            postgres    false    221            :           2606    16429    persona persona_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    223            �   e   x�3��)-,M�tv�	r��433�2��,I,M/M����p�b6�tK-�K�K�WHIU�IT��/JD1Ϙ381O�'�(5�*E���Xs�Ƃ���qqq �K3�      �   1   x�3�4202�5��52�42�tL.�,��4�2�.a�K���	W� }��      �   A   x�3�42�4426153�4202�5��52�t��+IL����KL.�,���CF\Fd�3&S_� ��)�      �      x������ � �      �   +   x�3�41��M,�L��I�JN���t��442��#�=... �`
     