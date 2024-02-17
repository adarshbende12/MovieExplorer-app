
package ;
import java.util.List;

public class MovieList {
    private long page;
    private long totalPages;
    private List<Result> results;
    private long totalResults;

    public long getPage() { return page; }
    public void setPage(long value) { this.page = value; }

    public long getTotalPages() { return totalPages; }
    public void setTotalPages(long value) { this.totalPages = value; }

    public List<Result> getResults() { return results; }
    public void setResults(List<Result> value) { this.results = value; }

    public long getTotalResults() { return totalResults; }
    public void setTotalResults(long value) { this.totalResults = value; }
}

// Result.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

import java.time.LocalDate;
class Result {
    private String overview;
    private OriginalLanguage originalLanguage;
    private String originalTitle;
    private boolean video;
    private String title;
    private List<Long> genreids;
    private String posterPath;
    private String backdropPath;
    private MediaType mediaType;
    private LocalDate releaseDate;
    private double popularity;
    private double voteAverage;
    private long id;
    private boolean adult;
    private long voteCount;

    public String getOverview() { return overview; }
    public void setOverview(String value) { this.overview = value; }

    public OriginalLanguage getOriginalLanguage() { return originalLanguage; }
    public void setOriginalLanguage(OriginalLanguage value) { this.originalLanguage = value; }

    public String getOriginalTitle() { return originalTitle; }
    public void setOriginalTitle(String value) { this.originalTitle = value; }

    public boolean getVideo() { return video; }
    public void setVideo(boolean value) { this.video = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public List<Long> getGenreids() { return genreids; }
    public void setGenreids(List<Long> value) { this.genreids = value; }

    public String getPosterPath() { return posterPath; }
    public void setPosterPath(String value) { this.posterPath = value; }

    public String getBackdropPath() { return backdropPath; }
    public void setBackdropPath(String value) { this.backdropPath = value; }

    public MediaType getMediaType() { return mediaType; }
    public void setMediaType(MediaType value) { this.mediaType = value; }

    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate value) { this.releaseDate = value; }

    public double getPopularity() { return popularity; }
    public void setPopularity(double value) { this.popularity = value; }

    public double getVoteAverage() { return voteAverage; }
    public void setVoteAverage(double value) { this.voteAverage = value; }

    public long getid() { return id; }
    public void setid(long value) { this.id = value; }

    public boolean getAdult() { return adult; }
    public void setAdult(boolean value) { this.adult = value; }

    public long getVoteCount() { return voteCount; }
    public void setVoteCount(long value) { this.voteCount = value; }
}

// MediaType.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

import java.io.IOException;

public enum MediaType {
    MOVIE;

    public String toValue() {
        switch (this) {
            case MOVIE: return "movie";
        }
        return null;
    }

    public static MediaType forValue(String value) throws IOException {
        if (value.equals("movie")) return MOVIE;
        throw new IOException("Cannot deserialize MediaType");
    }
}

// OriginalLanguage.java

// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

import java.io.IOException;

public enum OriginalLanguage {
    DE, EN, PL;

    public String toValue() {
        switch (this) {
            case DE: return "de";
            case EN: return "en";
            case PL: return "pl";
        }
        return null;
    }

    public static OriginalLanguage forValue(String value) throws IOException {
        if (value.equals("de")) return DE;
        if (value.equals("en")) return EN;
        if (value.equals("pl")) return PL;
        throw new IOException("Cannot deserialize OriginalLanguage");
    }
}
