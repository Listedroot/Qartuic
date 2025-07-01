# Contributing to Qartuic

Thank you for your interest in contributing to Qartuic! We welcome all real, production-grade contributions—no stubs, placeholders, or demo code.

## How to Contribute

- **Bug Reports:** Open an issue with detailed steps to reproduce, expected vs. actual behavior, and relevant logs or code.
- **Feature Requests:** Open an issue describing the feature, its use case, and any relevant protocol references.
- **Pull Requests:**
  - Fork the repo and create a feature branch.
  - Make sure your code is production-ready and fully implements the real protocol logic.
  - Add or update tests if relevant.
  - Follow the code style and architecture of the existing codebase.
  - Document your changes in code and in the README if they affect users.
  - Ensure all tests and builds pass (`mvn clean verify`).
- **Protocol Version Support:**
  - To add a new version, implement the `VersionedProtocol` interface and follow the structure of existing `ProtocolImpl` classes.
  - Ensure full handshake, state, and packet coverage for the new version.

## Coding Standards
- No placeholders, stubs, or demo code—only real, working implementations.
- All packet, registry, and state logic must be robust and spec-compliant.
- Explicit error handling: log or propagate errors, never swallow silently.
- Ensure thread safety and resource safety.

## FAQ for Contributors

**Q: Can I submit partial implementations or TODOs?**
A: No. Only complete, working implementations are accepted.

**Q: How do I get my changes reviewed?**
A: Open a pull request and request a review from a maintainer.

**Q: How do I add a new protocol version?**
A: Implement the `VersionedProtocol` interface and provide a full, spec-compliant `ProtocolImpl`.

**Q: How do I run tests?**
A: Use `mvn clean verify`.

**Q: Who maintains this project?**
A: See the AUTHORS or MAINTAINERS file (if present) or open an issue to contact the core team.
