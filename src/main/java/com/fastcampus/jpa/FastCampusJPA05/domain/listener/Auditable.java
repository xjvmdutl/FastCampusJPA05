package com.fastcampus.jpa.FastCampusJPA05.domain.listener;

import java.time.LocalDateTime;

public interface Auditable {
    LocalDateTime getCreateAt();
    LocalDateTime getUpdateAt();
    void setCreateAt(LocalDateTime createAt);
    void setUpdateAt(LocalDateTime updateAt);
}
