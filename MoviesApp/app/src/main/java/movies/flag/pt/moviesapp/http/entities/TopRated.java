package movies.flag.pt.moviesapp.http.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by franciscofarinha on 25/01/2018.
 */

public class TopRated extends SugarRecord implements Parcelable{


    public TopRated() {

    }

    /**
     * vote_count : 1051
     * id : 19404
     * video : false
     * vote_average : 9.1
     * title : Dilwale Dulhania Le Jayenge
     * popularity : 36.337606
     * poster_path : /uC6TTUhPpQCmgldGyYveKRAu8JN.jpg
     * original_language : hi
     * original_title : Dilwale Dulhania Le Jayenge
     * genre_ids : [35,18,10749]
     * backdrop_path : /nl79FQ8xWZkhL3rDr1v2RFFR6J0.jpg
     * adult : false
     * overview : Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for India with a mission at his hands, to claim his lady love under the noses of her whole family. Thus begins a saga.
     * release_date : 1995-10-20
     */

    @SerializedName("vote_count")
    private int voteCount;
    /*@SerializedName("id")
    private int idX;*/

    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("title")
    private String title;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("backdrop_path")
    private String backdropPath;


    @SerializedName("overview")
    private String overview;


    protected TopRated(Parcel in) {
        voteCount = in.readInt();
        voteAverage = in.readDouble();
        title = in.readString();
        popularity = in.readDouble();
        backdropPath = in.readString();
        posterPath = in.readString();
        overview = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(voteCount);
        dest.writeDouble(voteAverage);
        dest.writeString(title);
        dest.writeDouble(popularity);
        dest.writeString(backdropPath);
        dest.writeString(posterPath);
        dest.writeString(overview);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TopRated> CREATOR = new Creator<TopRated>() {
        @Override
        public TopRated createFromParcel(Parcel in) {
            return new TopRated(in);
        }

        @Override
        public TopRated[] newArray(int size) {
            return new TopRated[size];
        }
    };

    public int getVoteCount() {
        return voteCount;
    }


    public double getVoteAverage() {
        return voteAverage;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getPosterPath() {
        return posterPath;
    }




    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }




}
