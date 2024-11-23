-- 사용자 테이블
CREATE TABLE users (
    user_id VARCHAR(50) PRIMARY KEY,
    user_pw VARCHAR(100) NOT NULL,
    user_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(100) UNIQUE NOT NULL,
    user_nic VARCHAR(50) UNIQUE NOT NULL,
    user_img VARCHAR(255),
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' -- 활성화 상태 추가
);

-- 책 테이블
CREATE TABLE books (
    isbn VARCHAR(20) PRIMARY KEY,               -- ISBN은 고유하므로 PRIMARY KEY로 설정
    title VARCHAR(255) NOT NULL,               -- 책 제목은 필수
    author VARCHAR(255) NOT NULL,              -- 저자 이름, 길이를 100에서 255로 늘림 (긴 이름 고려)
    publisher VARCHAR(255) NOT NULL,           -- 출판사, 길이를 100에서 255로 늘림
    image VARCHAR(2083),                       -- 이미지 URL, 표준 URL 최대 길이에 맞춤
    pubdate DATE NOT NULL,                     -- 출판일, DATE 타입 적합
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE' -- 활성화 상태
);

-- 독후감 테이블
CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    isbn VARCHAR(20),
    review_title VARCHAR(200) NOT NULL,
    review_content TEXT NOT NULL,
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE', -- 활성화 상태 추가
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (isbn) REFERENCES books(isbn) ON DELETE CASCADE
);

-- 책 좋아요 테이블
CREATE TABLE book_like (
    book_like_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    isbn VARCHAR(20),
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE', -- 활성화 상태 추가
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (isbn) REFERENCES books(isbn) ON DELETE CASCADE,
    UNIQUE KEY unique_book_like (user_id, isbn)
);

-- 독후감 좋아요 테이블
CREATE TABLE review_like (
    review_like_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    review_id INT,
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE', -- 활성화 상태 추가
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (review_id) REFERENCES reviews(review_id) ON DELETE CASCADE,
    UNIQUE KEY unique_review_like (user_id, review_id)
);

-- 독후감 답글 테이블
CREATE TABLE review_comments (
    comment_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    review_id INT,
    comment_content TEXT NOT NULL,
    status ENUM('ACTIVE', 'INACTIVE') DEFAULT 'ACTIVE', -- 활성화 상태 추가
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (review_id) REFERENCES reviews(review_id) ON DELETE CASCADE
);
