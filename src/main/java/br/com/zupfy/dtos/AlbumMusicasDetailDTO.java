package br.com.zupfy.dtos;

import br.com.zupfy.models.Album;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumMusicasDetailDTO {

    private int id;
    private String nome;
    private int anoLancamento;
    @JsonIgnoreProperties({"album", "banda"})
    private List<MusicaDTO> musicas;

    public AlbumMusicasDetailDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public List<MusicaDTO> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<MusicaDTO> musicas) {
        this.musicas = musicas;
    }

    public static AlbumMusicasDetailDTO converterModelParaDTO(Album album){
        AlbumMusicasDetailDTO dto = new AlbumMusicasDetailDTO();

        dto.setAnoLancamento(album.getAnoLancamento());
        dto.setNome(album.getNome());
        dto.setId(album.getId());

        List<MusicaDTO> musicaDTOS = album.getMusicas().stream()
                .map(objeto -> MusicaDTO.converterModelParaDTO(objeto))
                .collect(Collectors.toList());

        dto.setMusicas(musicaDTOS);
        return dto;
    }
}
