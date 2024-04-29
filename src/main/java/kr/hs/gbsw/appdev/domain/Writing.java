package kr.hs.gbsw.appdev.domain;

import kr.hs.gbsw.appdev.entity.WritingEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Writing {

    private int writingIdx;

    private String title;

    private String content;

    private String writer;

    private String fileName;

    private Date writeTime;

    public static Writing toDomain(WritingEntity entity) {
        return Writing.builder()
                .writingIdx(entity.getWritingIdx())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .fileName(entity.getFileName())
                .writeTime(entity.getWriteTime())
                .build();
    }

    public static WritingEntity toEntity(Writing writing) {
        return WritingEntity.builder()
                .writingIdx(writing.getWritingIdx())
                .title(writing.getTitle())
                .content(writing.getContent())
                .writer(writing.getWriter())
                .fileName(writing.getFileName())
                .writeTime(writing.getWriteTime())
                .build();
    }

}
