USE greengram2024_v1;

CREATE TABLE USER (
      user_id BIGINT AUTO_INCREMENT PRIMARY KEY
    , uid VARCHAR(20) UNIQUE NOT NULL
    , upw VARCHAR(100) NOT NULL
    , nm VARCHAR(20) NOT NULL
    , pic VARCHAR(70)
    , created_at DATETIME NOT NULL DEFAULT current_timestamp
    , updated_at DATETIME ON UPDATE current_timestamp
);
CREATE TABLE feed (
      feed_id BIGINT AUTO_INCREMENT PRIMARY key
    , writer_id BIGINT NOT NULL
    , contents VARCHAR(1000)
    , location VARCHAR(30)
    , created_at DATETIME NOT NULL DEFAULT current_timestamp
    , updated_at DATETIME ON UPDATE current_timestamp
);

CREATE TABLE feed_pics(
      feed_pic_id BIGINT AUTO_INCREMENT PRIMARY KEY
    , feed_id BIGINT NOT NULL
    , pic VARCHAR(70) NOT NULL
    , created_at DATETIME NOT NULL DEFAULT current_timestamp
);

CREATE TABLE feed_favorite (
      feed_id BIGINT NOT NULL
    , user_id BIGINT NOT NULL
    , created_at DATETIME NOT NULL DEFAULT current_timestamp
    , PRIMARY KEY (feed_id, user_id)
);