package movies.flag.pt.moviesapp.http.entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franciscofarinha on 02/02/2018.
 */

public class UpcomingResponse {


    /**
     * results : [{"vote_count":1817,"id":354912,"video":false,"vote_average":7.7,"title":"Coco","popularity":268.471977,"poster_path":"/eKi8dIrr8voobbaGzDpe8w0PVbC.jpg","original_language":"en","original_title":"Coco","genre_ids":[16,12,35],"backdrop_path":"/askg3SMvhqEl4OL52YuvdtY40Yb.jpg","adult":false,"overview":"Despite his family\u2019s baffling generations-old ban on music, Miguel dreams of becoming an accomplished musician like his idol, Ernesto de la Cruz. Desperate to prove his talent, Miguel finds himself in the stunning and colorful Land of the Dead following a mysterious chain of events. Along the way, he meets charming trickster Hector, and together, they set off on an extraordinary journey to unlock the real story behind Miguel's family history.","release_date":"2017-10-27"},{"vote_count":158,"id":336843,"video":false,"vote_average":7.4,"title":"Maze Runner: The Death Cure","popularity":99.584239,"poster_path":"/7GgZ6DGezkh3szFdvskH5XD4V0t.jpg","original_language":"en","original_title":"Maze Runner: The Death Cure","genre_ids":[28,9648,878,53],"backdrop_path":"/bvbyidkMaBls1LTaIWYY6UmYTaL.jpg","adult":false,"overview":"Thomas leads his group of escaped Gladers on their final and most dangerous mission yet. To save their friends, they must break into the legendary Last City, a WCKD-controlled labyrinth that may turn out to be the deadliest maze of all. Anyone who makes it out alive will get answers to the questions the Gladers have been asking since they first arrived in the maze.","release_date":"2018-01-17"},{"vote_count":290,"id":446354,"video":false,"vote_average":6.8,"title":"The Post","popularity":96.299274,"poster_path":"/qyRwj5VvuTRdJ76o2grP93grNxt.jpg","original_language":"en","original_title":"The Post","genre_ids":[18,36],"backdrop_path":"/2LR3XKthtguN7vOz99Q91IeEl1i.jpg","adult":false,"overview":"A cover-up that spanned four U.S. Presidents pushed the country's first female newspaper publisher and a hard-driving editor to join an unprecedented battle between journalist and government. Inspired by true events.","release_date":"2017-12-22"},{"vote_count":927,"id":316029,"video":false,"vote_average":8,"title":"The Greatest Showman","popularity":89.010113,"poster_path":"/dfhztJRiElqmYW4kpvjYe1gENsD.jpg","original_language":"en","original_title":"The Greatest Showman","genre_ids":[18,10751,10402,10749],"backdrop_path":"/zpq404Sk7qQ7N4x3xOeNgp74GtU.jpg","adult":false,"overview":"The story of American showman P.T. Barnum, founder of the circus that became the famous traveling Ringling Bros. and Barnum & Bailey Circus.","release_date":"2017-12-20"},{"vote_count":597,"id":399055,"video":false,"vote_average":7.3,"title":"The Shape of Water","popularity":84.124169,"poster_path":"/iLYLADGA5oKGM92Ns1j9CDgk3iI.jpg","original_language":"en","original_title":"The Shape of Water","genre_ids":[18,14,10749],"backdrop_path":"/bAISaVhsaoyyQMZ55cpTwCdzek4.jpg","adult":false,"overview":"An other-worldly story, set against the backdrop of Cold War era America circa 1962, where a mute janitor working at a lab falls in love with an amphibious man being held captive there and devises a plan to help him escape.","release_date":"2017-12-08"},{"vote_count":17,"id":454699,"video":false,"vote_average":7,"title":"Happy Family","popularity":67.819297,"poster_path":"/qp1kMdB5TVZ5ZN7BdpGQbVhAbfh.jpg","original_language":"en","original_title":"Happy Family","genre_ids":[16],"backdrop_path":"/jFSwrtsYJ0QesgPrvShQNOTn8aV.jpg","adult":false,"overview":"Despite the title the Wishbone family are far from happy. In an attempt to reconnect as a family Mum, Emma, plans a fun night out. However her plan backfires when an evil witch curses them and they're all turned into Monsters.","release_date":"2017-08-24"},{"vote_count":29,"id":452773,"video":false,"vote_average":6.4,"title":"Tad the Lost Explorer and the Secret of King Midas","popularity":53.058394,"poster_path":"/7WtFoWtGp45PLNmajM8iGtjAA7B.jpg","original_language":"es","original_title":"Tadeo Jones 2: El secreto del rey Midas","genre_ids":[16,12,35],"backdrop_path":"/lP1iXFp9cFs42LWUDyktG8Sl5oS.jpg","adult":false,"overview":"Tad Jones, the most awkward explorer, must rescue his beloved Sara from a millionaire who is looking for King Midas' necklace.","release_date":"2017-08-25"},{"vote_count":3,"id":453201,"video":false,"vote_average":3.8,"title":"The 15:17 to Paris","popularity":50.187398,"poster_path":"/qxJQ0VBCuJkJhJmuWzxI408ngwd.jpg","original_language":"en","original_title":"The 15:17 to Paris","genre_ids":[53,18],"backdrop_path":"/gkkBhctHPGg8hrmtWbO3ySZoj4z.jpg","adult":false,"overview":"In August 2015, an ISIS terrorist boarded train #9364 from Brussels to Paris. Armed with an AK-47 and enough ammo to kill more than 500 people, the terrorist might have succeeded except for three American friends who refused to give in to fear. Stone was a martial arts enthusiast and airman first class in the U.S. Air Force, Skarlatos was a member of the Oregon National Guard, and all three pals proved fearless as they charged and ultimately overpowered the gunman after he emerged from a bathroom armed and ready to kill.","release_date":"2018-02-02"},{"vote_count":158,"id":429351,"video":false,"vote_average":4.4,"title":"12 Strong","popularity":49.153526,"poster_path":"/j18021qCeRi3yUBtqd2UFj1c0RQ.jpg","original_language":"en","original_title":"12 Strong","genre_ids":[10752,18,36],"backdrop_path":"/x5EUEv1N9g4BCX9GQXKvv3nqMVo.jpg","adult":false,"overview":"A team of CIA agents and special forces head into Afghanistan in the aftermath of the September 11th attacks in an attempt to dismantle the Taliban.","release_date":"2018-01-18"},{"vote_count":319,"id":301337,"video":false,"vote_average":5.1,"title":"Downsizing","popularity":48.641793,"poster_path":"/uLlmtN33rMuimRq6bu0OoNzCGGs.jpg","original_language":"en","original_title":"Downsizing","genre_ids":[878,18,35],"backdrop_path":"/5RzW9i3vFsXCPLqYwgNJV1QuSgk.jpg","adult":false,"overview":"A kindly occupational therapist undergoes a new procedure to be shrunken to four inches tall so that he and his wife can help save the planet and afford a nice lifestyle at the same time.","release_date":"2017-12-22"},{"vote_count":285,"id":396371,"video":false,"vote_average":6.7,"title":"Molly's Game","popularity":48.371055,"poster_path":"/h9hUP5ZJGsjL2wbERrGlj4dMjZq.jpg","original_language":"en","original_title":"Molly's Game","genre_ids":[80,18],"backdrop_path":"/yvbXGWjg30sj7rohEZvSe90jSJC.jpg","adult":false,"overview":"Molly Bloom, a young skier and former Olympic hopeful becomes a successful entrepreneur (and a target of an FBI investigation) when she establishes a high-stakes, international poker game.","release_date":"2017-12-21"},{"vote_count":833,"id":359940,"video":false,"vote_average":8.2,"title":"Three Billboards Outside Ebbing, Missouri","popularity":46.405307,"poster_path":"/vgvw6w1CtcFkuXXn004S5wQsHRl.jpg","original_language":"en","original_title":"Three Billboards Outside Ebbing, Missouri","genre_ids":[35,80,18],"backdrop_path":"/bJLJAtGjBj836UjJZNOwgrfe5Ps.jpg","adult":false,"overview":"After seven months have passed without a culprit in her daughter's murder case, Mildred Hayes makes a bold move, painting three signs leading into her town with a controversial message directed at Bill Willoughby, the town's revered chief of police. When his second-in-command Officer Jason Dixon, an immature mother's boy with a penchant for violence, gets involved, the battle between Mildred and Ebbing's law enforcement is only exacerbated.","release_date":"2017-11-10"},{"vote_count":1,"id":284054,"video":false,"vote_average":0,"title":"Black Panther","popularity":45.854214,"poster_path":"/kNNtazn7jrfPs4eTlpPMdl8sUm0.jpg","original_language":"en","original_title":"Black Panther","genre_ids":[28,12,18,878,53],"backdrop_path":"/6ELJEzQJ3Y45HczvreC3dg0GV5R.jpg","adult":false,"overview":"T'Challa, the new ruler of the advanced kingdom of Wakanda, must defend his land from being torn apart by enemies from outside and inside the country.","release_date":"2018-02-13"},{"vote_count":635,"id":398818,"video":false,"vote_average":8.4,"title":"Call Me by Your Name","popularity":43.919795,"poster_path":"/tcNniniS4rfqrLH0oORikJfnIwY.jpg","original_language":"en","original_title":"Call Me by Your Name","genre_ids":[10749,18],"backdrop_path":"/8ndqvvwDVe9oDUQF1Jt6NCjAn7z.jpg","adult":false,"overview":"Elio Perlman is spending the summer with his family at their vacation home in Lombardy, Italy. When his father hires a handsome doctoral student, the curious 17-year-old finds himself developing a growing attraction to the young man.","release_date":"2017-10-27"},{"vote_count":782,"id":395834,"video":false,"vote_average":7.5,"title":"Wind River","popularity":43.787927,"poster_path":"/pySivdR845Hom4u4T2WNkJxe6Ad.jpg","original_language":"en","original_title":"Wind River","genre_ids":[80,18,9648,53],"backdrop_path":"/iF9d73lbtDYeCsPhQmjtkEmlrYG.jpg","adult":false,"overview":"An FBI agent teams with the town's veteran game tracker to investigate a murder that occurred on a Native American reservation.","release_date":"2017-08-03"},{"vote_count":79,"id":449443,"video":false,"vote_average":5.7,"title":"Den of Thieves","popularity":37.074798,"poster_path":"/onnxOne4EVdpqtuTpEBtD1I8tdJ.jpg","original_language":"en","original_title":"Den of Thieves","genre_ids":[53,80],"backdrop_path":"/s3FDBLH4qc1IcjexB05Qvbn3wxO.jpg","adult":false,"overview":"While planning a bank heist, a thief gets trapped between two sets of criminals.","release_date":"2018-01-18"},{"vote_count":137,"id":384680,"video":false,"vote_average":5,"title":"Hostiles","popularity":36.662356,"poster_path":"/rqoezyB51GfhiloOB5ZErg5HXas.jpg","original_language":"en","original_title":"Hostiles","genre_ids":[12,18,37],"backdrop_path":"/j4F5Bd1pT2KUNToejtXkxVgrBQ3.jpg","adult":false,"overview":"A legendary Native American-hating Army captain nearing retirement in 1892 is given one last assignment: to escort a Cheyenne chief and his family through dangerous territory back to his Montana reservation.","release_date":"2017-12-22"},{"vote_count":103,"id":413362,"video":false,"vote_average":5.6,"title":"Roman J. Israel, Esq.","popularity":34.778303,"poster_path":"/8e5IGlLrVjwrlDcRtzSQkXhJFWl.jpg","original_language":"en","original_title":"Roman J. Israel, Esq.","genre_ids":[18],"backdrop_path":"/znfo6c7CB7g8XK3DHBhPTfIqvTB.jpg","adult":false,"overview":"Hard-nosed liberal lawyer Roman J. Israel has been fighting the good fight forever while others take the credit. When his partner \u2013 the firm\u2019s frontman \u2013 has a heart attack, Israel suddenly takes on that role. He soon discovers some unsettling truths about the firm \u2013 truths that conflict with his values of helping the poor and dispossessed \u2013 and finds himself in an existential crisis that leads to extreme actions.","release_date":"2017-11-10"},{"vote_count":0,"id":459910,"video":false,"vote_average":0,"title":"Braven","popularity":30.750135,"poster_path":"/253Bw5I3Zj3e2thCThjO7byEUCL.jpg","original_language":"en","original_title":"Braven","genre_ids":[28],"backdrop_path":"/uIWnlqVAQWkVXyW1mjsrlvoCItt.jpg","adult":false,"overview":"A logger defends his family from a group of dangerous drug runners.","release_date":"2018-02-01"},{"vote_count":16,"id":447665,"video":false,"vote_average":5.9,"title":"Kickboxer: Retaliation","popularity":27.61192,"poster_path":"/5EFXMBUoQHjgi5UxQ62Sj2RsIqM.jpg","original_language":"en","original_title":"Kickboxer: Retaliation","genre_ids":[28,18],"backdrop_path":"/nTH63dIC9D9lWhQlvCu4zSoESKj.jpg","adult":false,"overview":"One year after the events of \"Kickboxer: Vengeance\", Kurt Sloan has vowed never to return to Thailand. However, while gearing up for a MMA title shot, he finds himself sedated and forced back into Thailand, this time in prison. He is there because the ones responsible want him to face a 6'8\" 400 lbs. beast named Mongkut and in return for the fight, Kurt will get two million dollars and his freedom back. Kurt at first refuses, in which a bounty is placed on his head as a way to force him to face Mongkut. Kurt soon learns he will have no other choice and will undergo his most rigorous training yet under some unexpected mentors in order to face Mongkut in hopes to regain his freedom.","release_date":"2018-01-26"}]
     * page : 1
     * total_results : 316
     * dates : {"maximum":"2018-02-27","minimum":"2018-02-08"}
     * total_pages : 16
     */

    @SerializedName("page")
    private int page;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("dates")
    private DatesBean dates;
    @SerializedName("total_pages")
    private int totalPages;
    @SerializedName("results")
    private ArrayList<Upcoming> upcoming = new ArrayList<>();

    public  ArrayList<Upcoming> getUpcoming() { return upcoming; }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public DatesBean getDates() {
        return dates;
    }

    public void setDates(DatesBean dates) {
        this.dates = dates;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }



    public static class DatesBean {
    }

    public static class ResultsBean {
        /**
         * vote_count : 1817
         * id : 354912
         * video : false
         * vote_average : 7.7
         * title : Coco
         * popularity : 268.471977
         * poster_path : /eKi8dIrr8voobbaGzDpe8w0PVbC.jpg
         * original_language : en
         * original_title : Coco
         * genre_ids : [16,12,35]
         * backdrop_path : /askg3SMvhqEl4OL52YuvdtY40Yb.jpg
         * adult : false
         * overview : Despite his family’s baffling generations-old ban on music, Miguel dreams of becoming an accomplished musician like his idol, Ernesto de la Cruz. Desperate to prove his talent, Miguel finds himself in the stunning and colorful Land of the Dead following a mysterious chain of events. Along the way, he meets charming trickster Hector, and together, they set off on an extraordinary journey to unlock the real story behind Miguel's family history.
         * release_date : 2017-10-27
         */

        @SerializedName("title")
        private String title;
        @SerializedName("popularity")
        private double popularity;
        @SerializedName("poster_path")
        private String posterPath;
        @SerializedName("original_language")
        private String originalLanguage;
        @SerializedName("original_title")
        private String originalTitle;
        @SerializedName("backdrop_path")
        private String backdropPath;
        @SerializedName("adult")
        private boolean adult;
        @SerializedName("overview")
        private String overview;
        @SerializedName("release_date")
        private String releaseDate;
        @SerializedName("genre_ids")
        private List<Integer> genreIds;

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

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
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

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
        }
    }
}
