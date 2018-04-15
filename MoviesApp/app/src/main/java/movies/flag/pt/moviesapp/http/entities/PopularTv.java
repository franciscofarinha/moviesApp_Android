package movies.flag.pt.moviesapp.http.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by franciscofarinha on 19/01/2018.
 */

public class PopularTv extends SugarRecord implements Parcelable {


    public PopularTv() {

    }

    /**
     * original_name : The Big Bang Theory
     * genre_ids : [35]
     * name : A Teoria do Big Bang
     * popularity : 251.138468
     * origin_country : ["US"]
     * vote_count : 2476
     * first_air_date : 2007-09-24
     * backdrop_path : /nGsNruW3W27V6r4gkyc3iiEGsKR.jpg
     * original_language : en
     * id : 1418
     * vote_average : 6.9
     * overview : Quarks voam quando dois físicos nerds conhecem a nova vizinha: uma sensual atriz que os inspira a tentarem uma relação com uma mulher real.
     * poster_path : /y47TQybIv7GqrrAkmnt6jFciP7a.jpg
     */




    @SerializedName("original_name")
    private String originalName;
    @SerializedName("name")
    private String name;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("vote_count")
    private int voteCount;
    @SerializedName("first_air_date")
    private String firstAirDate;
    @SerializedName("backdrop_path")
    private String backdropPath;
    @SerializedName("original_language")
    private String originalLanguage;
    /*@SerializedName("id")
    private int id;*/
    @SerializedName("vote_average")
    private double voteAverage;
    @SerializedName("overview")
    private String overview;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("genre_ids")
    private List<Integer> genreIds;
    @SerializedName("origin_country")
    private List<String> originCountry;

    protected PopularTv(Parcel in) {
        originalName = in.readString();
        name = in.readString();
        popularity = in.readDouble();
        voteCount = in.readInt();
        firstAirDate = in.readString();
        backdropPath = in.readString();
        originalLanguage = in.readString();
        voteAverage = in.readDouble();
        overview = in.readString();
        posterPath = in.readString();
        originCountry = in.createStringArrayList();
    }

    public static final Creator<PopularTv> CREATOR = new Creator<PopularTv>() {
        @Override
        public PopularTv createFromParcel(Parcel in) {
            return new PopularTv(in);
        }

        @Override
        public PopularTv[] newArray(int size) {
            return new PopularTv[size];
        }
    };

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    /*public int getId() {



        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(originalName);
        parcel.writeString(name);
        parcel.writeDouble(popularity);
        parcel.writeInt(voteCount);
        parcel.writeString(firstAirDate);
        parcel.writeString(backdropPath);
        parcel.writeString(originalLanguage);
        parcel.writeDouble(voteAverage);
        parcel.writeString(overview);
        parcel.writeString(posterPath);
        parcel.writeStringList(originCountry);
    }
}
