package com.example.movies.API;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

public class Movies {
    /**
     * page : 1
     * total_results : 7360
     * total_pages : 368
     * results : [{"vote_count":2068,"id":19404,"video":false,"vote_average":9,"title":"Dilwale Dulhania Le Jayenge","popularity":19.434,"poster_path":"/uC6TTUhPpQCmgldGyYveKRAu8JN.jpg","original_language":"hi","original_title":"दिलवाले दुल्हनिया ले जायेंगे","genre_ids":[35,18,10749],"backdrop_path":"/nl79FQ8xWZkhL3rDr1v2RFFR6J0.jpg","adult":false,"overview":"Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.","release_date":"1995-10-20"},{},{},{},{"vote_count":4199,"id":372058,"video":false,"vote_average":8.6,"title":"Your Name.","popularity":25.536,"poster_path":"/xq1Ugd62d23K2knRUx6xxuALTZB.jpg","original_language":"ja","original_title":"君の名は。","genre_ids":[10749,16,18],"backdrop_path":"/nvsdKYPKwf51EAgC0xLJMB9kUZM.jpg","adult":false,"overview":"High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki\u2019s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.","release_date":"2016-08-26"},{"vote_count":8114,"id":424,"video":false,"vote_average":8.5,"title":"Schindler's List","popularity":26.212,"poster_path":"/yPisjyLweCl1tbgwgtzBCNCBle.jpg","original_language":"en","original_title":"Schindler's List","genre_ids":[18,36,10752],"backdrop_path":"/af98P1bc7lJsFjhHOVWXQgNNgSQ.jpg","adult":false,"overview":"The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.","release_date":"1993-12-15"},{"vote_count":5925,"id":240,"video":false,"vote_average":8.5,"title":"The Godfather: Part II","popularity":23.913,"poster_path":"/bVq65huQ8vHDd1a4Z37QtuyEvpA.jpg","original_language":"en","original_title":"The Godfather: Part II","genre_ids":[18,80],"backdrop_path":"/gLbBRyS7MBrmVUNce91Hmx9vzqI.jpg","adult":false,"overview":"In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba.","release_date":"1974-12-20"},{"vote_count":7466,"id":129,"video":false,"vote_average":8.5,"title":"Spirited Away","popularity":37.785,"poster_path":"/oRvMaJOmapypFUcQqpgHMZA6qL9.jpg","original_language":"ja","original_title":"千と千尋の神隠し","genre_ids":[16,10751,14],"backdrop_path":"/dUoGxrlUWDwjpzNggKt33uWlOvM.jpg","adult":false,"overview":"A young girl, Chihiro, becomes trapped in a strange new world of spirits. When her parents undergo a mysterious transformation, she must call upon the courage she never knew she had to free her family.","release_date":"2001-07-20"},{"vote_count":8363,"id":497,"video":false,"vote_average":8.5,"title":"The Green Mile","popularity":24.155,"poster_path":"/sOHqdY1RnSn6kcfAHKu28jvTebE.jpg","original_language":"en","original_title":"The Green Mile","genre_ids":[14,18,80],"backdrop_path":"/Rlt20sEbOQKPVjia7lUilFm49W.jpg","adult":false,"overview":"A supernatural tale set on death row in a Southern prison, where gentle giant John Coffey possesses the mysterious power to heal people's ailments. When the cell block's head guard, Paul Edgecomb, recognizes Coffey's miraculous gift, he tries desperately to help stave off the condemned man's execution.","release_date":"1999-12-10"},{"vote_count":7317,"id":637,"video":false,"vote_average":8.4,"title":"Life Is Beautiful","popularity":20.059,"poster_path":"/f7DImXDebOs148U4uPjI61iDvaK.jpg","original_language":"it","original_title":"La vita è bella","genre_ids":[35,18],"backdrop_path":"/bORe0eI72D874TMawOOFvqWS6Xe.jpg","adult":false,"overview":"A touching story of an Italian book seller of Jewish ancestry who lives in his own little fairy tale. His creative and happy life would come to an abrupt halt when his entire family is deported to a concentration camp during World War II. While locked up he tries to convince his son that the whole thing is just a game.","release_date":"1997-12-20"},{"vote_count":15331,"id":680,"video":false,"vote_average":8.4,"title":"Pulp Fiction","popularity":36.684,"poster_path":"/dM2w364MScsjFf8pfMbaWUcWrR.jpg","original_language":"en","original_title":"Pulp Fiction","genre_ids":[53,80],"backdrop_path":"/4cDFJr4HnXN5AdPw4AKrmLlMWdO.jpg","adult":false,"overview":"A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.","release_date":"1994-09-10"},{"vote_count":4175,"id":324857,"video":false,"vote_average":8.4,"title":"Spider-Man: Into the Spider-Verse","popularity":73.825,"poster_path":"/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg","original_language":"en","original_title":"Spider-Man: Into the Spider-Verse","genre_ids":[28,12,16,878,35],"backdrop_path":"/uUiId6cG32JSRI6RyBQSvQtLjz2.jpg","adult":false,"overview":"Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.","release_date":"2018-12-06"},{"vote_count":451,"id":40096,"video":false,"vote_average":8.4,"title":"A Dog's Will","popularity":10.15,"poster_path":"/uHEmM49YphluJnGep8Ef1qwD2QX.jpg","original_language":"pt","original_title":"O Auto da Compadecida","genre_ids":[12,35],"backdrop_path":"/alQqTpmEkxSLgajfEYTsTH6nAKB.jpg","adult":false,"overview":"The lively João Grilo and the sly Chicó are poor guys living in the hinterland who cheat a bunch of people in a small Northeast Brazil town. But when they die, they have to be judged by Christ, the Devil and the Virgin Mary, before they are admitted to paradise.","release_date":"2000-09-15"},{"vote_count":338,"id":517814,"video":false,"vote_average":8.4,"title":"Capernaum","popularity":18.986,"poster_path":"/mFnfTVADj8yOxwzprYOmTPselk8.jpg","original_language":"ar","original_title":"کفرناحوم","genre_ids":[18],"backdrop_path":"/zOKXsgIOaWLotZOBYopPxUkXfuF.jpg","adult":false,"overview":"Zain, a 12-year-old boy scrambling to survive on the streets of Beirut, sues his parents for having brought him into such an unjust world, where being a refugee with no documents means that your rights can easily be denied.","release_date":"2018-10-06"},{"vote_count":18994,"id":155,"video":false,"vote_average":8.4,"title":"The Dark Knight","popularity":41.071,"poster_path":"/1hRoyzDtpgMU7Dz4JF22RANzQO7.jpg","original_language":"en","original_title":"The Dark Knight","genre_ids":[18,28,80,53],"backdrop_path":"/hqkIcbrOHL86UncnHIsHVcVmzue.jpg","adult":false,"overview":"Batman raises the stakes in his war on crime. With the help of Lt. Jim Gordon and District Attorney Harvey Dent, Batman sets out to dismantle the remaining criminal organizations that plague the streets. The partnership proves to be effective, but they soon find themselves prey to a reign of chaos unleashed by a rising criminal mastermind known to the terrified citizens of Gotham as the Joker.","release_date":"2008-07-16"},{"vote_count":7151,"id":299534,"video":false,"vote_average":8.4,"title":"Avengers: Endgame","popularity":104.135,"poster_path":"/or06FN3Dka5tukK1e9sl16pB3iy.jpg","original_language":"en","original_title":"Avengers: Endgame","genre_ids":[12,878,28],"backdrop_path":"/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg","adult":false,"overview":"After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.","release_date":"2019-04-24"},{"vote_count":256,"id":14537,"video":false,"vote_average":8.4,"title":"Harakiri","popularity":11.676,"poster_path":"/5konZnIbcAxZjP616Cz5o9bKEfW.jpg","original_language":"ja","original_title":"切腹","genre_ids":[28,18,36],"backdrop_path":"/pz9fxHyGiiNLZ21bccAtwrMAH7f.jpg","adult":false,"overview":"Aging samurai Hanshiro Tsugumo arrives at the home of Kageyu Saito and asks to commit a ritual suicide on the property, which Saito thinks is a ploy to gain pity and a job. Saito tells Tsugumo of another samurai, Motome Chijiiwa, who threatened suicide as a stratagem, only to be forced to follow through on the task. When Tsugumo reveals that Chijiiwa was his son-in-law, the disclosure sets off a fierce conflict.","release_date":"1962-09-15"},{"vote_count":14929,"id":13,"video":false,"vote_average":8.4,"title":"Forrest Gump","popularity":34.841,"poster_path":"/yE5d3BUhE8hCnkMUJOo1QDoOGNz.jpg","original_language":"en","original_title":"Forrest Gump","genre_ids":[35,18,10749],"backdrop_path":"/wMgbnUVS9wbRGAdki8fqxKU1O0N.jpg","adult":false,"overview":"A man with a low IQ has accomplished great things in his life and been present during significant historic events\u2014in each case, far exceeding what anyone imagined he could do. But despite all he has achieved, his one true love eludes him.","release_date":"1994-07-06"},{"vote_count":16391,"id":550,"video":false,"vote_average":8.4,"title":"Fight Club","popularity":31.533,"poster_path":"/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg","original_language":"en","original_title":"Fight Club","genre_ids":[18],"backdrop_path":"/mMZRKb3NVo5ZeSPEIaNW9buLWQ0.jpg","adult":false,"overview":"A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.","release_date":"1999-10-15"},{"vote_count":4978,"id":539,"video":false,"vote_average":8.4,"title":"Psycho","popularity":26.003,"poster_path":"/81d8oyEFgj7FlxJqSDXWr8JH8kV.jpg","original_language":"en","original_title":"Psycho","genre_ids":[27,18],"backdrop_path":"/3md49VBCeqY6MSNyAVY6d5eC6bA.jpg","adult":false,"overview":"When larcenous real estate clerk Marion Crane goes on the lam with a wad of cash and hopes of starting a new life, she ends up at the notorious Bates Motel, where manager Norman Bates cares for his housebound mother. The place seems quirky, but fine\u2026 until Marion decides to take a shower.","release_date":"1960-06-16"}]
     */

    private int page;
    private int total_results;
    private int total_pages;
    private List<MoviesBean> results;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<MoviesBean> getResults() {
        return results;
    }

    public void setResults(List<MoviesBean> results) {
        this.results = results;
    }


    @Entity(tableName = "movies")
    public static class MoviesBean implements Parcelable {
        /**
         * vote_count : 2068
         * id : 19404
         * video : false
         * vote_average : 9
         * title : Dilwale Dulhania Le Jayenge
         * popularity : 19.434
         * poster_path : /uC6TTUhPpQCmgldGyYveKRAu8JN.jpg
         * original_language : hi
         * original_title : दिलवाले दुल्हनिया ले जायेंगे
         * genre_ids : [35,18,10749]
         * backdrop_path : /nl79FQ8xWZkhL3rDr1v2RFFR6J0.jpg
         * adult : false
         * overview : Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.
         * release_date : 1995-10-20
         */

        @Ignore
        private int vote_count;
        @PrimaryKey
        private int id;
        @Ignore
        private boolean video;
        private float vote_average;
        private String title;
        @Ignore
        private double popularity;
        private String poster_path;
        private String original_language;
        private String original_title;
        @Ignore
        private String backdrop_path;
        private boolean adult;
        private String overview;
        private String release_date;
        @Ignore
        private List<Integer> genre_ids;

        public MoviesBean(int id,float vote_average, String title, String poster_path, String original_language, String original_title, boolean adult, String overview, String release_date) {
            this.id = id;
            this.vote_average=vote_average;
            this.title = title;
            this.poster_path = poster_path;
            this.original_language = original_language;
            this.original_title = original_title;
            this.adult = adult;
            this.overview = overview;
            this.release_date = release_date;
        }

        public int getVote_count() {
            return vote_count;
        }

        public void setVote_count(int vote_count) {
            this.vote_count = vote_count;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public float getVote_average() {
            return vote_average;
        }

        public void setVote_average(int vote_average) {
            this.vote_average = vote_average;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public void setPoster_path(String poster_path) {
            this.poster_path = poster_path;
        }

        public String getOriginal_language() {
            return original_language;
        }

        public void setOriginal_language(String original_language) {
            this.original_language = original_language;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getBackdrop_path() {
            return backdrop_path;
        }

        public void setBackdrop_path(String backdrop_path) {
            this.backdrop_path = backdrop_path;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getRelease_date() {
            return release_date;
        }

        public void setRelease_date(String release_date) {
            this.release_date = release_date;
        }

        public List<Integer> getGenre_ids() {
            return genre_ids;
        }

        public void setGenre_ids(List<Integer> genre_ids) {
            this.genre_ids = genre_ids;
        }

        public String getRelease_year() {
            String[] date=release_date.split("-");
            return date[0];
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.vote_count);
            dest.writeInt(this.id);
            dest.writeByte(this.video ? (byte) 1 : (byte) 0);
            dest.writeFloat(this.vote_average);
            dest.writeString(this.title);
            dest.writeDouble(this.popularity);
            dest.writeString(this.poster_path);
            dest.writeString(this.original_language);
            dest.writeString(this.original_title);
            dest.writeString(this.backdrop_path);
            dest.writeByte(this.adult ? (byte) 1 : (byte) 0);
            dest.writeString(this.overview);
            dest.writeString(this.release_date);
            dest.writeList(this.genre_ids);
        }


        @Ignore
        protected MoviesBean(Parcel in) {
            this.vote_count = in.readInt();
            this.id = in.readInt();
            this.video = in.readByte() != 0;
            this.vote_average = in.readFloat();
            this.title = in.readString();
            this.popularity = in.readDouble();
            this.poster_path = in.readString();
            this.original_language = in.readString();
            this.original_title = in.readString();
            this.backdrop_path = in.readString();
            this.adult = in.readByte() != 0;
            this.overview = in.readString();
            this.release_date = in.readString();
            this.genre_ids = new ArrayList<Integer>();
            in.readList(this.genre_ids, Integer.class.getClassLoader());
        }

        public static final Creator<MoviesBean> CREATOR = new Creator<MoviesBean>() {
            @Override
            public MoviesBean createFromParcel(Parcel source) {
                return new MoviesBean(source);
            }

            @Override
            public MoviesBean[] newArray(int size) {
                return new MoviesBean[size];
            }
        };
    }

}
