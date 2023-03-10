package com.pil.group4.controllers;

import com.pil.group4.models.*;
import com.pil.group4.services.IRecyclingZoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/recycling-zone")
public class RecyclingZoneController {

    private final IRecyclingZoneService recyclingZoneService;

    @Autowired
    public RecyclingZoneController(IRecyclingZoneService recyclingZoneService) {
        this.recyclingZoneService = recyclingZoneService;
    }

    @GetMapping
    public List<RecyclingZoneModel> getRecyclingZones() {
        return this.recyclingZoneService.getRecyclingZones();
    }

    @Operation(summary = "Get recycling zone by id")
    @ApiResponse(responseCode = "200", description = "Found the recycling zone",
            content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json",
                    schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = RecyclingZoneModel.class)))
    @GetMapping("/{id}")
    public Optional<RecyclingZoneModel> getRecyclingZoneById(@Parameter(description =
            "Id of the recycling zone to be searched") @PathVariable("id") Long idRecyclingZone) {
        return recyclingZoneService.getRecyclingZoneById(idRecyclingZone);
    }

    @PostMapping
    public RecyclingZoneModel saveRecyclingZone(@RequestBody RecyclingZoneModel recyclingZone) {
        return this.recyclingZoneService.saveRecyclingZone(recyclingZone);
    }

    @PutMapping("/{id}")
    public RecyclingZoneModel updateRecyclingZoneById(@PathVariable("id") Long id, @RequestBody RecyclingZoneModel recyclingZone) {
        return this.recyclingZoneService.updateRecyclingZoneById(recyclingZone, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteOfRecyclingZoneById(@PathVariable("id") Long id) {
        return this.recyclingZoneService.deleteOfRecyclingZone(id);

    }

    @PutMapping("/{id}/supervisor/{idSupervisor}")
    public String addSupervisor(@PathVariable("id") Long id, @PathVariable("idSupervisor") Long idSupervisor) {
        return this.recyclingZoneService.addSupervisor(id, idSupervisor);
    }

    @DeleteMapping("/{id}/supervisor/{idSupervisor}")
    public String deleteSupervisor(@PathVariable("id") Long id, @PathVariable("idSupervisor") Long idSupervisor) {
        return this.recyclingZoneService.deleteSupervisor(id, idSupervisor);
    }

    @PutMapping("/{id}/supervisor/{idSupervisor}/change-classification-type")
    public Optional<RecyclingZoneModel> changeClassificationType(@PathVariable("id") Long id, @PathVariable("idSupervisor") Long idSupervisor, @RequestBody RecyclingZoneModel recyclingZone) {
        return this.recyclingZoneService.changeClassificationType(id, idSupervisor, recyclingZone);
    }

    @PutMapping("/{id}/supervisor/{idSupervisor}/change-state-of-the-zone")
    public Optional<RecyclingZoneModel> changeStateOfTheZone(@PathVariable("id") Long id, @PathVariable("idSupervisor") Long idSupervisor, @RequestBody RecyclingZoneModel recyclingZone) {
        return this.recyclingZoneService.changeStateOfTheZone(id, idSupervisor, recyclingZone);
    }

    @GetMapping("/supervisor/{idSupervisor}")
    public Optional<RecyclingZoneModel> getRecyclingZonesBySupervisor(@PathVariable("idSupervisor") Long idSupervisor) {
        return this.recyclingZoneService.getRecyclingZoneBySupervisor(idSupervisor);
    }

    @GetMapping("/location/department/{department}")
    public List<RecyclingZoneModel> getRecyclingZonesByDepartment(@PathVariable("department") String department) {
        return this.recyclingZoneService.getRecyclingZonesByDepartment(department);
    }

    @PutMapping("/{id}/supervisor/{idSupervisor}/needs-reclassification")
    public Optional<RecyclingZoneModel> needsReclassification(@PathVariable("id") Long id, @PathVariable("idSupervisor") Long idSupervisor, @RequestBody RecyclingZoneModel recyclingZone) {
        return this.recyclingZoneService.changeClassificationType(id, idSupervisor, recyclingZone);
    }

    @GetMapping("/findByClassificationType")
    public List<RecyclingZoneModel> findRecyclingZoneByClassificationType(@RequestParam("classificationType") ClassificationType classificationType) {
        return recyclingZoneService.findRecyclingZoneByClassificationType(classificationType);
    }

    @GetMapping("/findByOccupationCapacity")
    public List<RecyclingZoneModel> findRecyclingZoneByOccupationCapacity(@RequestParam("occupationCapacity") OccupationCapacity occupationCapacity) {
        return recyclingZoneService.findRecyclingZoneByOccupationCapacity(occupationCapacity);
    }

    @GetMapping("/findByStateOfTheZone")
    public List<RecyclingZoneModel> findRecyclingZoneByStateOfTheZone(@RequestParam("stateOfTheZone") StateOfTheZone stateOfTheZone) {
        return recyclingZoneService.findRecyclingZoneByStateOfTheZone(stateOfTheZone);
    }

    @GetMapping("recollection-route/x{x}/y{y}")
    public String getRecollectionRoute(@RequestBody List<Integer> recyclingZonesIds, @PathVariable("x") Integer x, @PathVariable("y") Integer y) {
        return this.recyclingZoneService.shortestRoute(recyclingZonesIds, new Point(x, y));
    }

    @PutMapping("/{id}/supervisor/{idSupervisor}/change-occupation-capacity")
    public Optional<RecyclingZoneModel> changeOccupationCapacity(@PathVariable("id") Long id, @PathVariable("idSupervisor") Long idSupervisor, @RequestBody RecyclingZoneModel recyclingZone) {
        return this.recyclingZoneService.changeOccupationCapacity(id, idSupervisor, recyclingZone);
    }

    @PutMapping("/{id}/complaint")
    public String addComplaint(@PathVariable("id") Long id, @RequestBody ComplaintModel complaint) {
        return this.recyclingZoneService.addComplaint(id, complaint);
    }

    @DeleteMapping("/{id}/complaint/{idComplaint}")
    public String deleteComplaint(@PathVariable("id") Long id, @PathVariable("idComplaint") Long idComplaint) {
        return this.recyclingZoneService.deleteComplaint(id, idComplaint);
    }

    @DeleteMapping("/{id}/complaint")
    public String deleteAllComplaints(@PathVariable("id") Long id) {
        return this.recyclingZoneService.cleanComplaints(id);
    }

    @GetMapping("{id}/complaint")
    public List<ComplaintModel> getRecyclingZoneComplaints(@PathVariable("id") Long id) {
        return this.recyclingZoneService.getRecyclingZoneComplaints(id);
    }

}