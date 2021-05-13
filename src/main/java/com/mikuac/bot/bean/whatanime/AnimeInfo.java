package com.mikuac.bot.bean.whatanime;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author Zero
 */
@Data
public class AnimeInfo {

    @JSONField(name = "Data")
    private GetData getData;

    @Data
    public static class StartDate {
        private int year;
        private int month;
        private int day;
    }

    @Data
    public static class EndDate {
        private int year;
        private int month;
        private int day;
    }

    @Data
    public static class CoverImage {
        private String large;
    }

    @Data
    public static class Media {
        private String type;
        private String format;
        private String status;
        private String season;
        private String episodes;
        private StartDate startDate;
        private EndDate endDate;
        private CoverImage coverImage;
    }

    @Data
    public static class GetData {
        @JSONField(name = "Media")
        private Media media;
    }

}
