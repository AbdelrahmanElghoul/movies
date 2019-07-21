package com.example.movies.API;

import java.util.List;

public class Videos {
    /**
     * id : 420818
     * results : [{"id":"5bf75c2f0e0a26266f0e1e04","iso_639_1":"en","iso_3166_1":"US","key":"4CbLXeGSDxg","name":"The Lion King Official Teaser Trailer","site":"YouTube","size":1080,"type":"Teaser"},{"id":"5c7364950e0a262c09800374","iso_639_1":"en","iso_3166_1":"US","key":"aQN75AKDwks","name":"The Lion King | Long Live the King","site":"YouTube","size":1080,"type":"Teaser"},{"id":"5cade34d0e0a26310d5a7bc5","iso_639_1":"en","iso_3166_1":"US","key":"7TavVZMewpY","name":"The Lion King Official Trailer","site":"YouTube","size":1080,"type":"Trailer"},{"id":"5cfe4318c3a3680e921e7e17","iso_639_1":"en","iso_3166_1":"US","key":"hoGhxfndjpM","name":"The Lion King Sneak Peek | \"Come Home\"","site":"YouTube","size":1080,"type":"Featurette"},{"id":"5d2632d0a698cf0010acf6e0","iso_639_1":"en","iso_3166_1":"US","key":"CA-gC-PaF48","name":"The Lion King - \"Circle of Life\" Official Teaser Trailer","site":"YouTube","size":1080,"type":"Teaser"},{"id":"5d26332637b3a9747d5463b4","iso_639_1":"en","iso_3166_1":"US","key":"SPuZoFTxHuw","name":"Lion King - \"Can You Feel The Love Tonight?\" Official Teaser Trailer","site":"YouTube","size":1080,"type":"Teaser"},{"id":"5d263354a698cf2b76a6acd4","iso_639_1":"en","iso_3166_1":"US","key":"hV0WtrFc3jc","name":"The Lion King Official Teaser (2019) Beyoncé as Nala","site":"YouTube","size":1080,"type":"Featurette"},{"id":"5d26336c37b3a9747d546430","iso_639_1":"en","iso_3166_1":"US","key":"flXkOTJBtvU","name":"\"The King Returns\" Featurette | The Lion King","site":"YouTube","size":1080,"type":"Featurette"}]
     */

    private int id;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * id : 5bf75c2f0e0a26266f0e1e04
         * iso_639_1 : en
         * iso_3166_1 : US
         * key : 4CbLXeGSDxg
         * name : The Lion King Official Teaser Trailer
         * site : YouTube
         * size : 1080
         * type : Teaser
         */

        private String id;
        private String iso_639_1;
        private String iso_3166_1;
        private String key;
        private String name;
        private String site;
        private int size;
        private String type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIso_639_1() {
            return iso_639_1;
        }

        public void setIso_639_1(String iso_639_1) {
            this.iso_639_1 = iso_639_1;
        }

        public String getIso_3166_1() {
            return iso_3166_1;
        }

        public void setIso_3166_1(String iso_3166_1) {
            this.iso_3166_1 = iso_3166_1;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
