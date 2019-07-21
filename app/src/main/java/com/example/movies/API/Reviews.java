package com.example.movies.API;

import java.util.List;

public class Reviews {
    /**
     * id : 420818
     * page : 1
     * results : [{"author":"SWITCH.",
     * "content":"\u2018The Lion King\u2019 is a catastrophe; a new low in the ever-diminishing returns of Disney\u2019s endless run of remakes. There\u2019s nothing redeeming about it, with every decision either ill-conceived or mishandled to the point of incompetence. In Favreau\u2019s hands, \u2018The Lion King\u2019 is rendered thunderously dull, lacking in any tension or complex characterisation, taking a laboriously long time to go nowhere and never once justifying its contentious existence. Even with my dislike of the original, I was flabbergasted at how thoroughly this film never attempts to understand why so many people love the 1994 film. If nothing else, this film makes it abundantly clear that Disney has no interest in making great cinema or honouring its own legacy. They don\u2019t care whether the film is good or whether you enjoy it. All they care about is using nostalgia to trick you into buying your ticket so they can make as much money off you as they can, and maybe if they throw some recognisable iconic moments from your childhood on the screen, they may even be able to fool you into thinking you\u2019d had a good time. \u2018The Lion King\u2019 is the ultimate diabolical apex of the commercialisation of nostalgia, and its inevitable box office success will just prove how easily we continue to be duped and how thoroughly they have trained us to not care about the quality of what we see. If this really is the future of mainstream cinema, then we are in serious, serious trouble.\r\n- Daniel Lammin\r\n\r\nRead Daniel's full article...\r\nhttps://www.maketheswitch.com.au/article/review-the-lion-king-a-catastrophic-and-soulless-remake-of-a-disney-classic","id":"5d2ddc7d6a300b0011a469df","url":"https://www.themoviedb.org/review/5d2ddc7d6a300b0011a469df"}]
     * total_pages : 1
     * total_results : 1
     */

    private int id;
    private int page;
    private int total_pages;
    private int total_results;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * author : SWITCH.
         * content : ‘The Lion King’ is a catastrophe; a new low in the ever-diminishing returns of Disney’s endless run of remakes. There’s nothing redeeming about it, with every decision either ill-conceived or mishandled to the point of incompetence. In Favreau’s hands, ‘The Lion King’ is rendered thunderously dull, lacking in any tension or complex characterisation, taking a laboriously long time to go nowhere and never once justifying its contentious existence. Even with my dislike of the original, I was flabbergasted at how thoroughly this film never attempts to understand why so many people love the 1994 film. If nothing else, this film makes it abundantly clear that Disney has no interest in making great cinema or honouring its own legacy. They don’t care whether the film is good or whether you enjoy it. All they care about is using nostalgia to trick you into buying your ticket so they can make as much money off you as they can, and maybe if they throw some recognisable iconic moments from your childhood on the screen, they may even be able to fool you into thinking you’d had a good time. ‘The Lion King’ is the ultimate diabolical apex of the commercialisation of nostalgia, and its inevitable box office success will just prove how easily we continue to be duped and how thoroughly they have trained us to not care about the quality of what we see. If this really is the future of mainstream cinema, then we are in serious, serious trouble.
         - Daniel Lammin

         Read Daniel's full article...
         https://www.maketheswitch.com.au/article/review-the-lion-king-a-catastrophic-and-soulless-remake-of-a-disney-classic
         * id : 5d2ddc7d6a300b0011a469df
         * url : https://www.themoviedb.org/review/5d2ddc7d6a300b0011a469df
         */

        private String author;
        private String content;
        private String id;
        private String url;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
