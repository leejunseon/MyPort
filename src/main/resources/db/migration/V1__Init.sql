-- TBL_USER Table Create SQL
CREATE TABLE TBL_USER
(
    U_NO            NUMBER(18, 0)    NOT NULL, 
    U_ID            VARCHAR2(20)     NOT NULL, 
    U_PW            VARCHAR2(20)     NOT NULL, 
    U_NAME          VARCHAR2(20)     NOT NULL, 
    U_EMAIL         VARCHAR2(20)     NOT NULL, 
    U_REGDATE       VARCHAR2(40)     DEFAULT to_char(sysdate, 'YYYYMMDD HH24:MI:SS') NOT NULL, 
    U_UPDATEDATE    VARCHAR2(40)     DEFAULT to_char(sysdate, 'YYYYMMDD HH24:MI:SS') NOT NULL, 
    CONSTRAINT PK_TBL_USER PRIMARY KEY (U_NO)
)
;

CREATE SEQUENCE TBL_USER_SEQ
START WITH 1
INCREMENT BY 1;


--DROP TRIGGER TBL_USER_AI_TRG;


--DROP SEQUENCE TBL_USER_SEQ;


COMMENT ON TABLE TBL_USER IS '유저';


COMMENT ON COLUMN TBL_USER.U_NO IS '유저 키';


COMMENT ON COLUMN TBL_USER.U_ID IS '유저 아이디';


COMMENT ON COLUMN TBL_USER.U_PW IS '유저 패스워드';


COMMENT ON COLUMN TBL_USER.U_NAME IS '유저 이름';


COMMENT ON COLUMN TBL_USER.U_EMAIL IS '유저 이메일';


COMMENT ON COLUMN TBL_USER.U_REGDATE IS '유저 등록 날짜시간';


COMMENT ON COLUMN TBL_USER.U_UPDATEDATE IS '유저 업데이트 날짜시간';


CREATE UNIQUE INDEX UQ_TBL_USER_1
    ON TBL_USER(U_ID);



-- TBL_ASSET Table Create SQL
CREATE TABLE TBL_ASSET
(
    A_NO            NUMBER(18, 0)    NOT NULL, 
    U_NO            NUMBER(18, 0)    NOT NULL, 
    A_NAME          VARCHAR2(20)     NOT NULL, 
    A_RATIO         NUMBER(18, 0)    NOT NULL, 
    A_REGDATE       VARCHAR2(40)     DEFAULT to_char(sysdate, 'YYYYMMDD HH24:MI:SS') NOT NULL, 
    A_UPDATEDATE    VARCHAR2(40)     DEFAULT to_char(sysdate, 'YYYYMMDD HH24:MI:SS') NOT NULL, 
    CONSTRAINT PK_TBL_ASSET PRIMARY KEY (A_NO)
)
;

CREATE SEQUENCE TBL_ASSET_SEQ
START WITH 1
INCREMENT BY 1;


--DROP TRIGGER TBL_ASSET_AI_TRG;


--DROP SEQUENCE TBL_ASSET_SEQ;


COMMENT ON TABLE TBL_ASSET IS '자산';


COMMENT ON COLUMN TBL_ASSET.A_NO IS '자산 키';


COMMENT ON COLUMN TBL_ASSET.U_NO IS '유저 키';


COMMENT ON COLUMN TBL_ASSET.A_NAME IS '자산 이름';


COMMENT ON COLUMN TBL_ASSET.A_RATIO IS '자산 설정비율';


COMMENT ON COLUMN TBL_ASSET.A_REGDATE IS '자산 등록 날짜시간';


COMMENT ON COLUMN TBL_ASSET.A_UPDATEDATE IS '자산 업데이트 날짜시간';


CREATE UNIQUE INDEX UQ_TBL_ASSET_1
    ON TBL_ASSET(U_NO)
;

CREATE UNIQUE INDEX UQ_TBL_ASSET_2
    ON TBL_ASSET(A_NAME)
;

ALTER TABLE TBL_ASSET
    ADD CONSTRAINT FK_TBL_ASSET_U_NO_TBL_USER_U_N FOREIGN KEY (U_NO)
        REFERENCES TBL_USER (U_NO)
;


-- TBL_COUNTRY Table Create SQL
CREATE TABLE TBL_COUNTRY
(
    C_NO            NUMBER(18, 0)    NOT NULL, 
    U_NO            NUMBER(18, 0)    NOT NULL, 
    C_NAME          VARCHAR2(20)     NOT NULL, 
    C_RATIO         NUMBER(18, 0)    NOT NULL, 
    C_REGDATE       VARCHAR2(40)     DEFAULT to_char(sysdate, 'YYYYMMDD HH24:MI:SS') NOT NULL, 
    C_UPDATEDATE    VARCHAR2(40)     DEFAULT to_char(sysdate, 'YYYYMMDD HH24:MI:SS') NOT NULL, 
    CONSTRAINT PK_TBL_COUNTRY PRIMARY KEY (C_NO)
)
;

CREATE SEQUENCE TBL_COUNTRY_SEQ
START WITH 1
INCREMENT BY 1;



--DROP TRIGGER TBL_COUNTRY_AI_TRG;


--DROP SEQUENCE TBL_COUNTRY_SEQ;


COMMENT ON TABLE TBL_COUNTRY IS '국가'
;

COMMENT ON COLUMN TBL_COUNTRY.C_NO IS '국가 키'
;

COMMENT ON COLUMN TBL_COUNTRY.U_NO IS '유저 키'
;

COMMENT ON COLUMN TBL_COUNTRY.C_NAME IS '국가 이름'
;

COMMENT ON COLUMN TBL_COUNTRY.C_RATIO IS '국가 설정비율'
;

COMMENT ON COLUMN TBL_COUNTRY.C_REGDATE IS '국가 등록 날짜시간'
;

COMMENT ON COLUMN TBL_COUNTRY.C_UPDATEDATE IS '국가 업데이트 날짜시간'
;

CREATE UNIQUE INDEX UQ_TBL_COUNTRY_1
    ON TBL_COUNTRY(U_NO)
;

CREATE UNIQUE INDEX UQ_TBL_COUNTRY_2
    ON TBL_COUNTRY(C_NAME)
;

ALTER TABLE TBL_COUNTRY
    ADD CONSTRAINT FK_TBL_COUNTRY_U_NO_TBL_USER_U FOREIGN KEY (U_NO)
        REFERENCES TBL_USER (U_NO)
;


-- TBL_INVESTMENT Table Create SQL
CREATE TABLE TBL_INVESTMENT
(
    I_NO            NUMBER(18, 0)    NOT NULL, 
    U_NO            NUMBER(18, 0)    NOT NULL, 
    C_NO            NUMBER(18, 0)    NOT NULL, 
    A_NO            NUMBER(18, 0)    NOT NULL, 
    I_NAME          VARCHAR2(20)     NOT NULL, 
    I_PRICE         NUMBER(18, 0)    NOT NULL, 
    I_NUM           NUMBER(18, 0)    NOT NULL, 
    I_REGDATE       VARCHAR2(40)     DEFAULT to_char(sysdate, 'YYYYMMDD HH24:MI:SS') NOT NULL, 
    I_UPDATEDATE    VARCHAR2(40)     DEFAULT to_char(sysdate, 'YYYYMMDD HH24:MI:SS') NOT NULL, 
    CONSTRAINT PK_TBL_INVESTMENT PRIMARY KEY (I_NO)
)
;

CREATE SEQUENCE TBL_INVESTMENT_SEQ
START WITH 1
INCREMENT BY 1;


--DROP TRIGGER TBL_INVESTMENT_AI_TRG;


--DROP SEQUENCE TBL_INVESTMENT_SEQ;


COMMENT ON TABLE TBL_INVESTMENT IS '투자 종목'
;

COMMENT ON COLUMN TBL_INVESTMENT.I_NO IS '투자종목 키'
;

COMMENT ON COLUMN TBL_INVESTMENT.U_NO IS '유저 키'
;

COMMENT ON COLUMN TBL_INVESTMENT.C_NO IS '국가 키'
;

COMMENT ON COLUMN TBL_INVESTMENT.A_NO IS '자산 키'
;

COMMENT ON COLUMN TBL_INVESTMENT.I_NAME IS '투자종목 이름'
;

COMMENT ON COLUMN TBL_INVESTMENT.I_PRICE IS '투자종목 가격'
;

COMMENT ON COLUMN TBL_INVESTMENT.I_NUM IS '투자종목 갯수'
;

COMMENT ON COLUMN TBL_INVESTMENT.I_REGDATE IS '투자종목 등록 날짜시간'
;

COMMENT ON COLUMN TBL_INVESTMENT.I_UPDATEDATE IS '투자종목 업데이트 날짜시간'
;

CREATE UNIQUE INDEX UQ_TBL_INVESTMENT_1
    ON TBL_INVESTMENT(U_NO)
;

CREATE UNIQUE INDEX UQ_TBL_INVESTMENT_2
    ON TBL_INVESTMENT(C_NO)
;

CREATE UNIQUE INDEX UQ_TBL_INVESTMENT_3
    ON TBL_INVESTMENT(A_NO)
;

CREATE UNIQUE INDEX UQ_TBL_INVESTMENT_4
    ON TBL_INVESTMENT(I_NAME)
;

CREATE OR REPLACE TRIGGER TBL_USER_AI_TRG
BEFORE INSERT ON TBL_USER
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT TBL_USER_SEQ.NEXTVAL
    INTO :NEW.U_NO
    FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TBL_ASSET_AI_TRG
BEFORE INSERT ON TBL_ASSET 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT TBL_ASSET_SEQ.NEXTVAL
    INTO :NEW.A_NO
    FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TBL_COUNTRY_AI_TRG
BEFORE INSERT ON TBL_COUNTRY 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT TBL_COUNTRY_SEQ.NEXTVAL
    INTO :NEW.C_NO
    FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TBL_INVESTMENT_AI_TRG
BEFORE INSERT ON TBL_INVESTMENT 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT TBL_INVESTMENT_SEQ.NEXTVAL
    INTO :NEW.I_NO
    FROM DUAL;
END;
/
