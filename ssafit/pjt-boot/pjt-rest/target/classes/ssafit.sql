-- 사용자 테이블
CREATE TABLE users (
    user_id VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 운동 영상 테이블
CREATE TABLE videos (
    video_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    url VARCHAR(500) NOT NULL,
    part VARCHAR(50) NOT NULL,  -- 운동 부위
    view_count INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 리뷰 테이블
CREATE TABLE reviews (
    review_id INT AUTO_INCREMENT PRIMARY KEY,
    video_id INT,
    user_id VARCHAR(50),
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (video_id) REFERENCES videos(video_id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
);

-- 찜하기 테이블
CREATE TABLE favorites (
    favorite_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id VARCHAR(50),
    video_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (video_id) REFERENCES videos(video_id) ON DELETE CASCADE,
    UNIQUE KEY unique_favorite (user_id, video_id)
);

-- 팔로우 테이블
CREATE TABLE follows (
    follow_id INT AUTO_INCREMENT PRIMARY KEY,
    follower_id VARCHAR(50),  -- 팔로우하는 사용자
    following_id VARCHAR(50), -- 팔로우되는 사용자
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (follower_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (following_id) REFERENCES users(user_id) ON DELETE CASCADE,
    UNIQUE KEY unique_follow (follower_id, following_id)
);

-- users 테이블 더미 데이터
INSERT INTO users (user_id, password, username, email) VALUES
('user1', 'pass1', '김철수', 'user1@example.com'),
('user2', 'pass2', '이영희', 'user2@example.com'),
('user3', 'pass3', '박민수', 'user3@example.com'),
('user4', 'pass4', '정미영', 'user4@example.com'),
('user5', 'pass5', '윤재호', 'user5@example.com'),
('user6', 'pass6', '송지은', 'user6@example.com'),
('user7', 'pass7', '임현우', 'user7@example.com'),
('user8', 'pass8', '홍서연', 'user8@example.com'),
('user9', 'pass9', '강동훈', 'user9@example.com'),
('user10', 'pass10', '조은지', 'user10@example.com'),
('user11', 'pass11', '권태준', 'user11@example.com'),
('user12', 'pass12', '신아라', 'user12@example.com'),
('user13', 'pass13', '류민호', 'user13@example.com'),
('user14', 'pass14', '백수진', 'user14@example.com'),
('user15', 'pass15', '오승훈', 'user15@example.com'),
('user16', 'pass16', '남궁소영', 'user16@example.com'),
('user17', 'pass17', '황준서', 'user17@example.com'),
('user18', 'pass18', '전지현', 'user18@example.com'),
('user19', 'pass19', '문동석', 'user19@example.com'),
('user20', 'pass20', '구민주', 'user20@example.com');

-- videos 테이블 더미 데이터
INSERT INTO videos (title, url, part, view_count) VALUES
('초보자를 위한 전신 운동', 'https://youtu.be/video1', '전신', 1500),
('30분 홈트레이닝 루틴', 'https://youtu.be/video2', '전신', 2000),
('상체 근력 강화 운동', 'https://youtu.be/video3', '상체', 1800),
('하체 다이어트 운동', 'https://youtu.be/video4', '하체', 2200),
('복근 만들기 5분 운동', 'https://youtu.be/video5', '복부', 3000),
('힙업 운동 모음', 'https://youtu.be/video6', '하체', 2500),
('어깨 넓어지는 운동', 'https://youtu.be/video7', '상체', 1700),
('팔뚝 살 빼는 운동', 'https://youtu.be/video8', '상체', 1900),
('허리 통증 완화 스트레칭', 'https://youtu.be/video9', '전신', 2100),
('전신 지방 태우는 유산소 운동', 'https://youtu.be/video10', '전신', 2800),
('복부 옆구리 운동', 'https://youtu.be/video11', '복부', 2300),
('허벅지 안쪽 살 빼는 운동', 'https://youtu.be/video12', '하체', 2000),
('등 근육 만들기 운동', 'https://youtu.be/video13', '상체', 1600),
('가슴 운동 루틴', 'https://youtu.be/video14', '상체', 1800),
('종아리 운동 모음', 'https://youtu.be/video15', '하체', 1400),
('전신 스트레칭', 'https://youtu.be/video16', '전신', 2600),
('근력 강화 운동 루틴', 'https://youtu.be/video17', '전신', 2100),
('다이어트 댄스 운동', 'https://youtu.be/video18', '전신', 3200),
('팔 운동 모음', 'https://youtu.be/video19', '상체', 1700),
('허리 라인 만들기 운동', 'https://youtu.be/video20', '복부', 2400);

-- reviews 테이블 더미 데이터
INSERT INTO reviews (video_id, user_id, content) VALUES
(1, 'user1', '초보자도 따라하기 쉬운 좋은 영상이에요!'),
(2, 'user2', '30분이 금방 지나갔어요. 효과적인 운동이었습니다.'),
(3, 'user3', '상체 운동 효과 굿굿'),
(4, 'user4', '하체 운동 후 다리가 풀리는 느낌이에요ㅠㅠ'),
(5, 'user5', '복근 운동 최고! 매일 하고 있어요'),
(6, 'user6', '힙업 효과 좋아요! 추천합니다'),
(7, 'user7', '어깨가 넓어지는 게 느껴져요'),
(8, 'user8', '팔뚝 살 빼기 좋은 운동이에요'),
(9, 'user9', '허리 통증이 많이 완화되었어요'),
(10, 'user10', '땀이 많이 나는 좋은 유산소 운동이에요'),
(11, 'user11', '옆구리 살 빼는데 효과적이에요'),
(12, 'user12', '허벅지 안쪽 자극이 잘 와요'),
(13, 'user13', '등 근육 운동 최고예요!'),
(14, 'user14', '가슴 운동 루틴 굿!'),
(15, 'user15', '종아리 운동 꾸준히 해볼게요'),
(16, 'user16', '전신 스트레칭으로 몸이 가벼워졌어요'),
(17, 'user17', '근력이 늘어나는 게 느껴져요'),
(18, 'user18', '재미있는 댄스 운동이에요'),
(19, 'user19', '팔 운동 루틴 좋아요!'),
(20, 'user20', '허리 라인이 생기는 것 같아요');

-- favorites 테이블 더미 데이터
INSERT INTO favorites (user_id, video_id) VALUES
('user1', 5), ('user1', 10), ('user1', 15),
('user2', 2), ('user2', 7), ('user2', 12),
('user3', 3), ('user3', 8), ('user3', 13),
('user4', 4), ('user4', 9), ('user4', 14),
('user5', 1), ('user5', 6), ('user5', 11),
('user6', 16), ('user6', 17), ('user6', 18),
('user7', 19), ('user7', 20), ('user7', 1),
('user8', 2), ('user8', 3), ('user8', 4),
('user9', 5), ('user9', 6), ('user9', 7),
('user10', 8), ('user10', 9), ('user10', 10),
('user11', 11), ('user11', 12), ('user11', 13),
('user12', 14), ('user12', 15), ('user12', 16),
('user13', 17), ('user13', 18), ('user13', 19),
('user14', 20), ('user14', 1), ('user14', 2),
('user15', 3), ('user15', 4), ('user15', 5),
('user16', 6), ('user16', 7), ('user16', 8),
('user17', 9), ('user17', 10), ('user17', 11),
('user18', 12), ('user18', 13), ('user18', 14),
('user19', 15), ('user19', 16), ('user19', 17),
('user20', 18), ('user20', 19), ('user20', 20);

-- follows 테이블 더미 데이터
INSERT INTO follows (follower_id, following_id) VALUES
('user1', 'user2'), ('user1', 'user3'), ('user1', 'user4'),
('user2', 'user3'), ('user2', 'user4'), ('user2', 'user5'),
('user3', 'user4'), ('user3', 'user5'), ('user3', 'user6'),
('user4', 'user5'), ('user4', 'user6'), ('user4', 'user7'),
('user5', 'user6'), ('user5', 'user7'), ('user5', 'user8'),
('user6', 'user7'), ('user6', 'user8'), ('user6', 'user9'),
('user7', 'user8'), ('user7', 'user9'), ('user7', 'user10'),
('user8', 'user9'), ('user8', 'user10'), ('user8', 'user11'),
('user9', 'user10'), ('user9', 'user11'), ('user9', 'user12'),
('user10', 'user11'), ('user10', 'user12'), ('user10', 'user13'),
('user11', 'user12'), ('user11', 'user13'), ('user11', 'user14'),
('user12', 'user13'), ('user12', 'user14'), ('user12', 'user15'),
('user13', 'user14'), ('user13', 'user15'), ('user13', 'user16'),
('user14', 'user15'), ('user14', 'user16'), ('user14', 'user17'),
('user15', 'user16'), ('user15', 'user17'), ('user15', 'user18'),
('user16', 'user17'), ('user16', 'user18'), ('user16', 'user19'),
('user17', 'user18'), ('user17', 'user19'), ('user17', 'user20'),
('user18', 'user19'), ('user18', 'user20'), ('user18', 'user1'),
('user19', 'user20'), ('user19', 'user1'), ('user19', 'user2'),
('user20', 'user1'), ('user20', 'user2'), ('user20', 'user3');