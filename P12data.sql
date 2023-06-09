PGDMP     +    4                {           P12data    14.5    14.5                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    40992    P12data    DATABASE     e   CREATE DATABASE "P12data" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'French_France.1252';
    DROP DATABASE "P12data";
                postgres    false            �            1259    65568    dico_user_roles    TABLE     j   CREATE TABLE public.dico_user_roles (
    dico_user_id integer NOT NULL,
    roles_id integer NOT NULL
);
 #   DROP TABLE public.dico_user_roles;
       public         heap    postgres    false            �            1259    65572 
   dico_users    TABLE       CREATE TABLE public.dico_users (
    id integer NOT NULL,
    address character varying(65),
    email character varying(65),
    first_name character varying(65),
    last_name character varying(65),
    password character varying(65),
    phone character varying(65)
);
    DROP TABLE public.dico_users;
       public         heap    postgres    false            �            1259    65571    dico_users_id_seq    SEQUENCE     �   CREATE SEQUENCE public.dico_users_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.dico_users_id_seq;
       public          postgres    false    211                       0    0    dico_users_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.dico_users_id_seq OWNED BY public.dico_users.id;
          public          postgres    false    210            �            1259    65579    roles    TABLE     W   CREATE TABLE public.roles (
    id integer NOT NULL,
    name character varying(65)
);
    DROP TABLE public.roles;
       public         heap    postgres    false            �            1259    65578    roles_id_seq    SEQUENCE     �   CREATE SEQUENCE public.roles_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.roles_id_seq;
       public          postgres    false    213                       0    0    roles_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.roles_id_seq OWNED BY public.roles.id;
          public          postgres    false    212            e           2604    65575    dico_users id    DEFAULT     n   ALTER TABLE ONLY public.dico_users ALTER COLUMN id SET DEFAULT nextval('public.dico_users_id_seq'::regclass);
 <   ALTER TABLE public.dico_users ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210    211            f           2604    65582    roles id    DEFAULT     d   ALTER TABLE ONLY public.roles ALTER COLUMN id SET DEFAULT nextval('public.roles_id_seq'::regclass);
 7   ALTER TABLE public.roles ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    213    212    213            �          0    65568    dico_user_roles 
   TABLE DATA           A   COPY public.dico_user_roles (dico_user_id, roles_id) FROM stdin;
    public          postgres    false    209   �       �          0    65572 
   dico_users 
   TABLE DATA           `   COPY public.dico_users (id, address, email, first_name, last_name, password, phone) FROM stdin;
    public          postgres    false    211   �       �          0    65579    roles 
   TABLE DATA           )   COPY public.roles (id, name) FROM stdin;
    public          postgres    false    213   $                  0    0    dico_users_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.dico_users_id_seq', 4, true);
          public          postgres    false    210                       0    0    roles_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.roles_id_seq', 1, false);
          public          postgres    false    212            h           2606    65577    dico_users dico_users_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.dico_users
    ADD CONSTRAINT dico_users_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.dico_users DROP CONSTRAINT dico_users_pkey;
       public            postgres    false    211            l           2606    65584    roles roles_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    213            j           2606    65586 &   dico_users ukq1xis2r07vmfoigwk938l7ry8 
   CONSTRAINT     b   ALTER TABLE ONLY public.dico_users
    ADD CONSTRAINT ukq1xis2r07vmfoigwk938l7ry8 UNIQUE (email);
 P   ALTER TABLE ONLY public.dico_users DROP CONSTRAINT ukq1xis2r07vmfoigwk938l7ry8;
       public            postgres    false    211            m           2606    65587 +   dico_user_roles fk5j5vibpy91jld9gefwt6pp04r    FK CONSTRAINT     �   ALTER TABLE ONLY public.dico_user_roles
    ADD CONSTRAINT fk5j5vibpy91jld9gefwt6pp04r FOREIGN KEY (roles_id) REFERENCES public.roles(id);
 U   ALTER TABLE ONLY public.dico_user_roles DROP CONSTRAINT fk5j5vibpy91jld9gefwt6pp04r;
       public          postgres    false    3180    213    209            n           2606    65592 +   dico_user_roles fk5r3ar1oeqyu4kdiyxisj716qc    FK CONSTRAINT     �   ALTER TABLE ONLY public.dico_user_roles
    ADD CONSTRAINT fk5r3ar1oeqyu4kdiyxisj716qc FOREIGN KEY (dico_user_id) REFERENCES public.dico_users(id);
 U   ALTER TABLE ONLY public.dico_user_roles DROP CONSTRAINT fk5r3ar1oeqyu4kdiyxisj716qc;
       public          postgres    false    211    209    3176            �      x�3�4�2bc 6�=... ��      �   2  x�=��r�0 ��ux
�1$���h�J��N7)	r�! >}q�������@�Fe-�K�V��]c0Elj����4PD�:7qts���F~�����n��I���𣐗�' �ejX�u�R���6\5u��雠-����=7��l���$v�;�H�R`AK/=;P�>�5�=i
PpP�*�#�U���.��A%�ۆk���K��^�3:���{����Co�R��:�{#��f>үcwSb�0U�����k߾�{(#"�A�]F/��P҆����\yۑ�D����#�I��5M��5oU      �      x�3���q�v����� %��     