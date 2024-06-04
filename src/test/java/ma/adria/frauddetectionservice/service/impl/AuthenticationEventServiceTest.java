package ma.adria.frauddetectionservice.service.impl;

import ma.adria.frauddetectionservice.model.*;
import ma.adria.frauddetectionservice.model.event.AuthenticationEvent;
import ma.adria.frauddetectionservice.repository.AccountRepository;
import ma.adria.frauddetectionservice.repository.ContratRepository;
import ma.adria.frauddetectionservice.repository.DeviceRepository;
import ma.adria.frauddetectionservice.repository.GenericRepository;
import ma.adria.frauddetectionservice.utils.MapHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class AuthenticationEventServiceTest {
    @Mock
    private DeviceRepository deviceRepository;

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private GenericRepository<AuthenticationEvent> genericRepository;

    @Mock
    private MapHelper mapHelper;

    @InjectMocks
    private AuthenticationEventService authenticationEventService;

    @Test
    void givenValidAuthenticationEvent_whenSave_thenReturnsSavedEvent() {
        // Given
        AuthenticationEvent authenticationEvent = AuthenticationEvent.builder()
                .id(1L)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .reference("ref123")
                .timestamp(LocalDateTime.now())
                .canal(Event.Canal.MOBILE)
                .activityTime(LocalDateTime.now())
                .username("testUser")
                .bankCode("BC123")
                .countryCode("CC123")
                .segment("PARTICULIER")
                .location(Location.builder()
                        .id(5L)
                        .ipAddress("192.168.1.1")
                        .createdAt(LocalDateTime.of(2024, 1, 1, 0, 0))
                        .updatedAt(LocalDateTime.of(2024, 1, 1, 0, 0))
                        .geolocation(Geolocation.builder()
                                .latitude(40.712F)
                                .longitude(-74.0060F)
                                .build())
                        .build())
                .contrat(Contrat.builder()
                        .id(2L)
                        .createdAt(LocalDateTime.of(2024, 1, 1, 0, 0))
                        .updatedAt(LocalDateTime.of(2024, 1, 1, 0, 0))
                        .contratID("contratID123")
                        .build())
                .device(Device.builder()
                        .id(3L)
                        .createdAt(LocalDateTime.of(2024, 1, 1, 0, 0))
                        .updatedAt(LocalDateTime.of(2024, 1, 1, 0, 0))
                        .fingerprint("deviceFingerprint")
                        .deviceType("Smartphone")
                        .browser("Chrome")
                        .browserVersion("89.0")
                        .os("Android")
                        .manufacturer("Samsung")
                        .model("Galaxy S21")
                        .build())
                .motif("testMotif")
                .build();
        when(genericRepository.save(any(AuthenticationEvent.class))).thenReturn(authenticationEvent);

        // When
        AuthenticationEvent result = authenticationEventService.save(authenticationEvent);

        // Then
        assertEquals(authenticationEvent, result);
        verify(genericRepository, times(1)).save(authenticationEvent);
    }

    @Test
    void givenNewDevice_whenHandleDevice_thenReturnsSavedDevice() {
        // Given
        Device device = Device.builder()
                .id(1L)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .fingerprint("newFingerprint")
                .deviceType("Smartphone")
                .browser("Chrome")
                .browserVersion("89.0")
                .os("Android")
                .manufacturer("Samsung")
                .model("Galaxy S21")
                .build();


        when(deviceRepository.findByFingerprint(anyString())).thenReturn(Optional.empty());
        when(deviceRepository.save(any(Device.class))).thenReturn(device);

        // When
        Device result = authenticationEventService.handleDevice(device);

        // Then
        assertEquals(device, result);
        verify(deviceRepository, times(1)).save(device);
    }

    @Test
    void givenExistingDevice_whenHandleDevice_thenReturnsUpdatedDevice() {
        // Given
        Device device = Device.builder()
                .id(1L)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .fingerprint("existingFingerprint")
                .deviceType("Smartphone")
                .browser("Chrome")
                .browserVersion("89.0")
                .os("Android")
                .manufacturer("Samsung")
                .model("Galaxy S21")
                .build();

        when(deviceRepository.findByFingerprint(anyString())).thenReturn(Optional.of(device));
        when(deviceRepository.save(any(Device.class))).thenReturn(device);
        // When
        Device result = authenticationEventService.handleDevice(device);

        // Then
        assertEquals(device, result);
        verify(mapHelper, times(1)).mapWithSkipNull(any(Device.class), eq(device));
        verify(deviceRepository, times(1)).save(device);
    }
    @Test
    void givenNewContrat_whenHandleContrat_thenReturnsSavedContrat() {
        // Given
        Contrat contrat = Contrat.builder()
                .id(1L)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .contratID("newContratID")
                .build();

        when(contratRepository.findByContratID(anyString())).thenReturn(Optional.empty());
        when(contratRepository.save(any(Contrat.class))).thenReturn(contrat);

        // When
        Contrat result = authenticationEventService.handleContrat(contrat);

        // Then
        assertEquals(contrat, result);
        verify(contratRepository, times(1)).save(contrat);
    }

    @Test
    void givenExistingContrat_whenHandleContrat_thenReturnsUpdatedContrat() {
        // Given
        Contrat contrat = Contrat.builder()
                .id(1L)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .contratID("newContratID").build();

        when(contratRepository.findByContratID(anyString())).thenReturn(Optional.of(contrat));
        when(contratRepository.save(any(Contrat.class))).thenReturn(contrat);

        // When
        Contrat result = authenticationEventService.handleContrat(contrat);

        // Then
        assertEquals(contrat, result);
        verify(mapHelper, times(1)).mapWithSkipNull(any(Contrat.class), eq(contrat));
        verify(contratRepository, times(1)).save(contrat);
    }

}