package movies.flag.pt.moviesapp.http.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franciscofarinha on 25/01/2018.
 */

public class TopRatedResponse {


    /**
     * page : 1
     * total_results : 8057
     * total_pages : 403
     * results : [{"vote_count":1051,"id":19404,"video":false,"vote_average":9.1,"title":"Dilwale Dulhania Le Jayenge","popularity":36.337606,"poster_path":"/uC6TTUhPpQCmgldGyYveKRAu8JN.jpg","original_language":"hi","original_title":"Dilwale Dulhania Le Jayenge","genre_ids":[35,18,10749],"backdrop_path":"/nl79FQ8xWZkhL3rDr1v2RFFR6J0.jpg","adult":false,"overview":"Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.","release_date":"1995-10-20"},{"vote_count":79,"id":20532,"video":false,"vote_average":8.7,"title":"Sansho the Bailiff","popularity":25.351137,"poster_path":"/deBjt3LT3UQHRXiNX1fu28lAtK6.jpg","original_language":"ja","original_title":"山椒大夫","genre_ids":[18],"backdrop_path":"/keaFMNUr1OpdHzPWJ0qeDP8hrO8.jpg","adult":false,"overview":"In medieval Japan a compassionate governor is sent into exile. His wife and children try to join him, but are separated, and the children grow up amid suffering and oppression.","release_date":"1954-03-31"},{"vote_count":89,"id":452522,"video":false,"vote_average":8.7,"title":"Twin Peaks","popularity":23.891334,"poster_path":"/zQsEi6096L7PvowV39dtdqdW16f.jpg","original_language":"en","original_title":"Twin Peaks","genre_ids":[18,9648],"backdrop_path":"/xqjGKLwLZeujg4fiBTOqhZkoL31.jpg","adult":false,"overview":"Standalone version of the series pilot with an alternate, closed ending, produced for the European VHS market.","release_date":"1989-12-31"},{"vote_count":9322,"id":278,"video":false,"vote_average":8.5,"title":"The Shawshank Redemption","popularity":42.254081,"poster_path":"/9O7gLzmreU0nGkIB6K3BsJbzvNv.jpg","original_language":"en","original_title":"The Shawshank Redemption","genre_ids":[18,80],"backdrop_path":"/xBKGJQsAIeweesB79KC89FpBrVr.jpg","adult":false,"overview":"Framed in the 1940s for the double murder of his wife and her lover, upstanding banker Andy Dufresne begins a new life at the Shawshank prison, where he puts his accounting skills to work for an amoral warden. During his long stretch in prison, Dufresne comes to be admired by the other inmates -- including an older prisoner named Red -- for his integrity and unquenchable sense of hope.","release_date":"1994-09-23"},{"vote_count":1748,"id":372058,"video":false,"vote_average":8.5,"title":"Your Name.","popularity":41.711262,"poster_path":"/xq1Ugd62d23K2knRUx6xxuALTZB.jpg","original_language":"ja","original_title":"君の名は。","genre_ids":[10749,16,18],"backdrop_path":"/6vkhRvsRvWpmaRVyCXaxTkIEb7j.jpg","adult":false,"overview":"High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki\u2019s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.","release_date":"2016-08-26"},{"vote_count":6923,"id":238,"video":false,"vote_average":8.5,"title":"The Godfather","popularity":70.443223,"poster_path":"/rPdtLWNsZmAtoZl9PK7S2wE3qiS.jpg","original_language":"en","original_title":"The Godfather","genre_ids":[18,80],"backdrop_path":"/6xKCYgH16UuwEGAyroLU6p8HLIn.jpg","adult":false,"overview":"Spanning the years 1945 to 1955, a chronicle of the fictional Italian-American Corleone crime family. When organized crime family patriarch, Vito Corleone barely survives an attempt on his life, his youngest son, Michael steps in to take care of the would-be killers, launching a campaign of bloody revenge.","release_date":"1972-03-14"},{"vote_count":4653,"id":129,"video":false,"vote_average":8.4,"title":"Spirited Away","popularity":54.181876,"poster_path":"/dL11DBPcRhWWnJcFXl9A07MrqTI.jpg","original_language":"ja","original_title":"千と千尋の神隠し","genre_ids":[16,10751,14],"backdrop_path":"/mnpRKVSXBX6jb56nabvmGKA0Wig.jpg","adult":false,"overview":"A young girl, Chihiro, becomes trapped in a strange new world of spirits. When her parents undergo a mysterious transformation, she must call upon the courage she never knew she had to free her family.","release_date":"2001-07-20"},{"vote_count":5164,"id":424,"video":false,"vote_average":8.4,"title":"Schindler's List","popularity":29.860539,"poster_path":"/yPisjyLweCl1tbgwgtzBCNCBle.jpg","original_language":"en","original_title":"Schindler's List","genre_ids":[18,36,10752],"backdrop_path":"/rIpSszng8P0DL0TimSzZbpfnvh1.jpg","adult":false,"overview":"The true story of how businessman Oskar Schindler saved over a thousand Jewish lives from the Nazis while they worked as slaves in his factory during World War II.","release_date":"1993-11-29"},{"vote_count":3996,"id":240,"video":false,"vote_average":8.4,"title":"The Godfather: Part II","popularity":52.034283,"poster_path":"/tHbMIIF51rguMNSastqoQwR0sBs.jpg","original_language":"en","original_title":"The Godfather: Part II","genre_ids":[18,80],"backdrop_path":"/gLbBRyS7MBrmVUNce91Hmx9vzqI.jpg","adult":false,"overview":"In the continuing saga of the Corleone crime family, a young Vito Corleone grows up in Sicily and in 1910s New York. In the 1950s, Michael Corleone attempts to expand the family business into Las Vegas, Hollywood and Cuba.","release_date":"1974-12-20"},{"vote_count":243,"id":339877,"video":false,"vote_average":8.4,"title":"Loving Vincent","popularity":40.906386,"poster_path":"/qlrhwUDe7YOZujAYanK6ij2vbY5.jpg","original_language":"en","original_title":"Loving Vincent","genre_ids":[16,18],"backdrop_path":"/vRejuzhA14eu6JwY1p8xX5Dln0y.jpg","adult":false,"overview":"The film brings the paintings of Vincent van Gogh to life to tell his remarkable story. Every one of the 65,000 frames of the film is an oil-painting hand-painted by 125 professional oil-painters who travelled from all across the world to the Loving Vincent studios in Poland and Greece to be a part of the production. As remarkable as Vincent\u2019s brilliant paintings are his passionate and ill-fated life and mysterious death.","release_date":"2017-08-02"},{"vote_count":5162,"id":244786,"video":false,"vote_average":8.3,"title":"Whiplash","popularity":48.880731,"poster_path":"/lIv1QinFqz4dlp5U4lQ6HaiskOZ.jpg","original_language":"en","original_title":"Whiplash","genre_ids":[18],"backdrop_path":"/6bbZ6XyvgfjhQwbplnUh1LSj1ky.jpg","adult":false,"overview":"Under the direction of a ruthless instructor, a talented young drummer begins to pursue perfection at any cost, even his humanity.","release_date":"2014-10-10"},{"vote_count":10134,"id":680,"video":false,"vote_average":8.3,"title":"Pulp Fiction","popularity":58.896739,"poster_path":"/dM2w364MScsjFf8pfMbaWUcWrR.jpg","original_language":"en","original_title":"Pulp Fiction","genre_ids":[53,80],"backdrop_path":"/9rZg1J6vMQoDVSgRyWcpJa8IAGy.jpg","adult":false,"overview":"A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.","release_date":"1994-09-10"},{"vote_count":4421,"id":637,"video":false,"vote_average":8.3,"title":"Life Is Beautiful","popularity":35.213932,"poster_path":"/f7DImXDebOs148U4uPjI61iDvaK.jpg","original_language":"it","original_title":"La vita è bella","genre_ids":[35,18],"backdrop_path":"/bORe0eI72D874TMawOOFvqWS6Xe.jpg","adult":false,"overview":"A touching story of an Italian book seller of Jewish ancestry who lives in his own little fairy tale. His creative and happy life would come to an abrupt halt when his entire family is deported to a concentration camp during World War II. While locked up he tries to convince his son that the whole thing is just a game.","release_date":"1997-12-20"},{"vote_count":11162,"id":550,"video":false,"vote_average":8.3,"title":"Fight Club","popularity":55.070038,"poster_path":"/adw6Lq9FiC9zjYEpOqfq03ituwp.jpg","original_language":"en","original_title":"Fight Club","genre_ids":[18],"backdrop_path":"/87hTDiay2N2qWyX4Ds7ybXi9h8I.jpg","adult":false,"overview":"A ticking-time-bomb insomniac and a slippery soap salesman channel primal male aggression into a shocking new form of therapy. Their concept catches on, with underground \"fight clubs\" forming in every town, until an eccentric gets in the way and ignites an out-of-control spiral toward oblivion.","release_date":"1999-10-15"},{"vote_count":309,"id":455661,"video":false,"vote_average":8.3,"title":"In a Heartbeat","popularity":21.739219,"poster_path":"/wJUJROdLOtOzMixkjkx1aaZGSLl.jpg","original_language":"en","original_title":"In a Heartbeat","genre_ids":[10751,16,10749,35],"backdrop_path":"/4datX8btikWEikf7esqEe6fhw.jpg","adult":false,"overview":"A closeted boy runs the risk of being outed by his own heart after it pops out of his chest to chase down the boy of his dreams.","release_date":"2017-06-01"},{"vote_count":346,"id":313106,"video":false,"vote_average":8.3,"title":"Doctor Who: The Day of the Doctor","popularity":9.554818,"poster_path":"/lQy2QVcacuH55k37K9Ox0gw3YpZ.jpg","original_language":"en","original_title":"Doctor Who: The Day of the Doctor","genre_ids":[878,12],"backdrop_path":"/8bxjRFqFztBoXdVEx6q2u66a0s1.jpg","adult":false,"overview":"In 2013, something terrible is awakening in London's National Gallery; in 1562, a murderous plot is afoot in Elizabethan England; and somewhere in space an ancient battle reaches its devastating conclusion. All of reality is at stake as the Doctor's own dangerous past comes back to haunt him.","release_date":"2013-11-23"},{"vote_count":424,"id":398818,"video":false,"vote_average":8.3,"title":"Call Me by Your Name","popularity":36.161488,"poster_path":"/tcNniniS4rfqrLH0oORikJfnIwY.jpg","original_language":"en","original_title":"Call Me by Your Name","genre_ids":[10749,18],"backdrop_path":"/8ndqvvwDVe9oDUQF1Jt6NCjAn7z.jpg","adult":false,"overview":"Elio Perlman is spending the summer with his family at their vacation home in Lombardy, Italy. When his father hires a handsome doctoral student, the curious 17-year-old finds himself developing a growing attraction to the young man.","release_date":"2017-10-27"},{"vote_count":2427,"id":389,"video":false,"vote_average":8.3,"title":"12 Angry Men","popularity":31.210601,"poster_path":"/3W0v956XxSG5xgm7LB6qu8ExYJ2.jpg","original_language":"en","original_title":"12 Angry Men","genre_ids":[18],"backdrop_path":"/lH2Ga8OzjU1XlxJ73shOlPx6cRw.jpg","adult":false,"overview":"The defense and the prosecution have rested and the jury is filing into the jury room to decide if a young Spanish-American is guilty or innocent of murdering his father. What begins as an open and shut case soon becomes a mini-drama of each of the jurors' prejudices and preconceptions about the trial, the accused, and each other.","release_date":"1957-03-25"},{"vote_count":1366,"id":311,"video":false,"vote_average":8.3,"title":"Once Upon a Time in America","popularity":24.915509,"poster_path":"/x733R4ISI0RbKeHhVkXdTMFmTFr.jpg","original_language":"en","original_title":"Once Upon a Time in America","genre_ids":[18,80],"backdrop_path":"/vnT6HzjLSDrAweHn9xWykb8Ii6T.jpg","adult":false,"overview":"A former Prohibition-era Jewish gangster returns to the Lower East Side of Manhattan over thirty years later, where he once again must confront the ghosts and regrets of his old life.","release_date":"1984-05-23"},{"vote_count":83,"id":17663,"video":false,"vote_average":8.3,"title":"Anne of Green Gables","popularity":6.69969,"poster_path":"/rw12vUIMVXqUbqYDmKamUCI4CVs.jpg","original_language":"en","original_title":"Anne of Green Gables","genre_ids":[18,10751],"backdrop_path":"/9qUvWPRou0KnsUfMxsEOpm8uzDv.jpg","adult":false,"overview":"At the turn of the century on Prince Edward Island, Matthew Cuthbert and his sister Marilla decide to take on an orphan boy as help for their farm. But they get an unexpected jolt when they're mistakenly sent a girl instead: Anne Shirley. Anne's a dreamer with an unusual point of view, far removed from Marilla's pragmatic ways, and it's only on trial that Marilla agrees to keep Anne.","release_date":"1985-12-01"}]
     */

    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private ArrayList<TopRated> topRated = new ArrayList<>();

    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public ArrayList<TopRated> getTopRated() { return topRated; }


}
